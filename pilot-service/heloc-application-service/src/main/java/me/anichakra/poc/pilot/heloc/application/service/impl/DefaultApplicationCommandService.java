package me.anichakra.poc.pilot.heloc.application.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Date;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.CommandService;
import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.EventObject;
import me.anichakra.poc.pilot.heloc.application.domain.ApplicationStatus;
import me.anichakra.poc.pilot.heloc.application.domain.LoanApplication;
import me.anichakra.poc.pilot.heloc.application.domain.ProgressStage;
import me.anichakra.poc.pilot.heloc.application.repo.ApplicationRepository;
import me.anichakra.poc.pilot.heloc.application.repo.BorrowerRepository;
import me.anichakra.poc.pilot.heloc.application.service.ApplicationCommandService;

@CommandService
public class DefaultApplicationCommandService implements ApplicationCommandService {

	@Inject
	private ApplicationRepository applicationRepository;

	@Inject
	private BorrowerRepository borrowerRepository;

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public LoanApplication createApplication(LoanApplication application) {
		application.setApplicationStatus(ApplicationStatus.STARTED);
		application.setProgressStage(ProgressStage.PROFILE);
		application.setCreatedDate(new Date());
		application.setUpdatedDate(new Date());
		LoanApplication saved = applicationRepository.saveAndFlush(application);

		// Run the full pipeline automatically after creation
		return runPipeline(saved);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public LoanApplication updateApplication(LoanApplication application) {
		application.setUpdatedDate(new Date());
		return applicationRepository.saveAndFlush(application);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public LoanApplication submitApplication(Long applicationId) {
		LoanApplication application = applicationRepository.findById(applicationId).get();
		// If pipeline hasn't run yet, run it now
		if (application.getCreditScore() == null) {
			return runPipeline(application);
		}
		application.setApplicationStatus(ApplicationStatus.PROFILE_COMPLETE);
		application.setProgressStage(ProgressStage.CREDIT);
		application.setUpdatedDate(new Date());
		return applicationRepository.saveAndFlush(application);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public LoanApplication linkCosigner(Long applicationId, Long cosignerId) {
		LoanApplication application = applicationRepository.findById(applicationId).get();
		application.setCosignerId(cosignerId);
		application.setUpdatedDate(new Date());
		return applicationRepository.saveAndFlush(application);
	}

	// ── Pipeline Orchestration ──────────────────────────────────────────────

	private LoanApplication runPipeline(LoanApplication app) {
		try {
			// Stage 1: Credit Decisioning (Experian Mock)
			applyCreditDecisioning(app);
			app.setApplicationStatus(ApplicationStatus.CREDIT_PULLED);
			app.setProgressStage(ProgressStage.CREDIT);
			app.setUpdatedDate(new Date());
			applicationRepository.saveAndFlush(app);

			// If credit is denied outright, stop pipeline
			if ("DENIED".equals(app.getCreditDecision())) {
				app.setUnderwritingStatus("DENIED");
				app.setUnderwritingNotes("Application denied due to credit score below threshold.");
				app.setApplicationStatus(ApplicationStatus.DECISIONED);
				app.setProgressStage(ProgressStage.DECISION);
				app.setUpdatedDate(new Date());
				return applicationRepository.saveAndFlush(app);
			}

			// Stage 2: Open Banking (Argyle Integration)
			applyOpenBanking(app);
			app.setApplicationStatus(ApplicationStatus.PRICED);
			app.setProgressStage(ProgressStage.PRICING);
			app.setUpdatedDate(new Date());
			applicationRepository.saveAndFlush(app);

			// Stage 3: Property Appraisal (AVM Integration)
			applyPropertyAppraisal(app);
			app.setUpdatedDate(new Date());
			applicationRepository.saveAndFlush(app);

			// Stage 4: Underwriting
			applyUnderwriting(app);
			app.setUpdatedDate(new Date());

			// Final status based on underwriting
			if ("APPROVED".equals(app.getUnderwritingStatus())) {
				app.setApplicationStatus(ApplicationStatus.FUNDED);
				app.setProgressStage(ProgressStage.FUNDING);
			} else if ("MANUAL_REVIEW".equals(app.getUnderwritingStatus())) {
				app.setApplicationStatus(ApplicationStatus.DOCUMENTS_UPLOADED);
				app.setProgressStage(ProgressStage.DOCUMENTS);
			} else {
				app.setApplicationStatus(ApplicationStatus.DECISIONED);
				app.setProgressStage(ProgressStage.DECISION);
			}

			return applicationRepository.saveAndFlush(app);
		} catch (Exception e) {
			// If pipeline fails, save what we have and return
			app.setUpdatedDate(new Date());
			return applicationRepository.saveAndFlush(app);
		}
	}

	// ── Stage 1: Experian Mock Credit Pull ──────────────────────────────────

	private void applyCreditDecisioning(LoanApplication app) {
		// Generate deterministic credit score based on application ID
		long id = app.getId() != null ? app.getId() : 1L;
		int baseScore = 680 + (int) ((id * 37) % 140); // Range: 680-819

		app.setCreditScore(baseScore);

		// Calculate DTI from loan amount (mock)
		BigDecimal loanAmt = app.getLoanAmount() != null ? app.getLoanAmount() : BigDecimal.valueOf(50000);
		double dti = 25.0 + ((id * 13) % 20); // Range: 25-44%
		app.setDti(Math.round(dti * 100.0) / 100.0);

		// Calculate CLTV (mock: loan amount / appraised value estimate)
		double cltv = 60.0 + ((id * 17) % 30); // Range: 60-89%
		app.setCltv(Math.round(cltv * 100.0) / 100.0);

		// Interest rate based on credit score
		double rate;
		if (baseScore >= 760) {
			rate = 6.25;
		} else if (baseScore >= 720) {
			rate = 7.00;
		} else if (baseScore >= 680) {
			rate = 7.75;
		} else if (baseScore >= 640) {
			rate = 8.50;
		} else {
			rate = 9.99;
		}
		app.setInterestRate(rate);

		// Credit decision
		if (baseScore >= 700) {
			app.setCreditDecision("APPROVED");
			app.setCreditDecisionReasons("Credit score meets minimum threshold. DTI within acceptable range.");
		} else if (baseScore >= 640) {
			app.setCreditDecision("CONDITIONAL");
			app.setCreditDecisionReasons("Credit score is marginal. Additional documentation may be required.");
		} else {
			app.setCreditDecision("DENIED");
			app.setCreditDecisionReasons("Credit score below minimum threshold of 640.");
		}
	}

	// ── Stage 2: Argyle Open Banking Integration ────────────────────────────

	private void applyOpenBanking(LoanApplication app) {
		long id = app.getId() != null ? app.getId() : 1L;

		// Mock bank account data (simulating Argyle account linking)
		String[] banks = {"Citizens Bank", "Chase", "Bank of America", "Wells Fargo", "TD Bank"};
		app.setBankName(banks[(int) (id % banks.length)]);
		app.setMaskedAccountNumber("****" + String.format("%04d", (id * 7919) % 10000));
		app.setAutopayEnrolled(id % 3 != 0);

		// Mock income/expense verification
		BigDecimal monthlyIncome = BigDecimal.valueOf(5000 + (id * 311) % 10000).setScale(2, RoundingMode.HALF_UP);
		BigDecimal monthlyExpenses = monthlyIncome.multiply(BigDecimal.valueOf(0.55 + ((id * 7) % 20) / 100.0)).setScale(2, RoundingMode.HALF_UP);
		app.setMonthlyIncome(monthlyIncome);
		app.setMonthlyExpenses(monthlyExpenses);

		// Cashflow score based on income-to-expense ratio
		double ratio = monthlyIncome.doubleValue() / Math.max(monthlyExpenses.doubleValue(), 1.0);
		int cashflowScore = Math.min(950, (int) (ratio * 400));
		app.setCashflowScore(cashflowScore);
	}

	// ── Stage 3: AVM Property Appraisal ─────────────────────────────────────

	private void applyPropertyAppraisal(LoanApplication app) {
		long id = app.getId() != null ? app.getId() : 1L;
		BigDecimal loanAmt = app.getLoanAmount() != null ? app.getLoanAmount() : BigDecimal.valueOf(50000);

		// AVM estimated value: typically higher than loan amount
		double multiplier = 2.5 + ((id * 23) % 30) / 10.0; // 2.5x to 5.5x
		BigDecimal appraisedValue = loanAmt.multiply(BigDecimal.valueOf(multiplier)).setScale(2, RoundingMode.HALF_UP);
		app.setAppraisedValue(appraisedValue);

		// AVM confidence score
		double confidence = 0.75 + ((id * 19) % 20) / 100.0; // 0.75 to 0.94
		app.setAvmConfidence(Math.round(confidence * 100.0) / 100.0);

		app.setAppraisalDate(new Date());

		// Recalculate CLTV with actual appraised value
		if (appraisedValue.compareTo(BigDecimal.ZERO) > 0) {
			double realCltv = loanAmt.doubleValue() / appraisedValue.doubleValue() * 100.0;
			app.setCltv(Math.round(realCltv * 100.0) / 100.0);
		}
	}

	// ── Stage 4: Underwriting Decision ──────────────────────────────────────

	private void applyUnderwriting(LoanApplication app) {
		Integer creditScore = app.getCreditScore() != null ? app.getCreditScore() : 0;
		Double dti = app.getDti() != null ? app.getDti() : 50.0;
		Double cltv = app.getCltv() != null ? app.getCltv() : 100.0;
		Integer cashflow = app.getCashflowScore() != null ? app.getCashflowScore() : 0;

		StringBuilder notes = new StringBuilder();

		// Scoring-based underwriting decision
		int riskPoints = 0;

		if (creditScore >= 740) {
			riskPoints += 3;
			notes.append("Excellent credit score (").append(creditScore).append("). ");
		} else if (creditScore >= 700) {
			riskPoints += 2;
			notes.append("Good credit score (").append(creditScore).append("). ");
		} else if (creditScore >= 660) {
			riskPoints += 1;
			notes.append("Fair credit score (").append(creditScore).append("). ");
		} else {
			notes.append("Below-threshold credit score (").append(creditScore).append("). ");
		}

		if (dti <= 30.0) {
			riskPoints += 2;
			notes.append("Low DTI ratio (").append(String.format("%.1f", dti)).append("%). ");
		} else if (dti <= 43.0) {
			riskPoints += 1;
			notes.append("Acceptable DTI ratio (").append(String.format("%.1f", dti)).append("%). ");
		} else {
			notes.append("High DTI ratio (").append(String.format("%.1f", dti)).append("%). ");
		}

		if (cltv <= 80.0) {
			riskPoints += 2;
			notes.append("CLTV within guidelines (").append(String.format("%.1f", cltv)).append("%). ");
		} else if (cltv <= 90.0) {
			riskPoints += 1;
			notes.append("Elevated CLTV (").append(String.format("%.1f", cltv)).append("%). ");
		} else {
			notes.append("High CLTV exceeds guidelines (").append(String.format("%.1f", cltv)).append("%). ");
		}

		if (cashflow >= 750) {
			riskPoints += 2;
			notes.append("Strong cashflow score (").append(cashflow).append(").");
		} else if (cashflow >= 600) {
			riskPoints += 1;
			notes.append("Adequate cashflow score (").append(cashflow).append(").");
		} else {
			notes.append("Weak cashflow score (").append(cashflow).append(").");
		}

		// Decision based on total risk points
		if (riskPoints >= 7) {
			app.setUnderwritingStatus("APPROVED");
			app.setApprovedCreditLine(app.getLoanAmount());
			// Calculate interest-only monthly payment
			if (app.getInterestRate() != null && app.getLoanAmount() != null) {
				double monthlyRate = app.getInterestRate() / 100.0 / 12.0;
				BigDecimal payment = app.getLoanAmount().multiply(BigDecimal.valueOf(monthlyRate)).setScale(2, RoundingMode.HALF_UP);
				app.setMonthlyPayment(payment);
			}
		} else if (riskPoints >= 4) {
			app.setUnderwritingStatus("MANUAL_REVIEW");
			// Reduce approved line for conditional approvals
			BigDecimal reducedLine = app.getLoanAmount() != null
					? app.getLoanAmount().multiply(BigDecimal.valueOf(0.80)).setScale(2, RoundingMode.HALF_UP)
					: BigDecimal.ZERO;
			app.setApprovedCreditLine(reducedLine);
		} else {
			app.setUnderwritingStatus("DENIED");
		}

		app.setUnderwritingNotes(notes.toString().trim());
	}
}
