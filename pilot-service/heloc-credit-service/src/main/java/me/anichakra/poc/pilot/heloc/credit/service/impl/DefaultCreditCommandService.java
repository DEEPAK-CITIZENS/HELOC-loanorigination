package me.anichakra.poc.pilot.heloc.credit.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Optional;

import javax.inject.Inject;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

import me.anichakra.poc.pilot.framework.annotation.CommandService;
import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.EventObject;
import me.anichakra.poc.pilot.heloc.credit.domain.CreditDecision;
import me.anichakra.poc.pilot.heloc.credit.domain.CreditReport;
import me.anichakra.poc.pilot.heloc.credit.repo.CreditDecisionRepository;
import me.anichakra.poc.pilot.heloc.credit.repo.CreditReportRepository;
import me.anichakra.poc.pilot.heloc.credit.service.CreditCommandService;

@CommandService
public class DefaultCreditCommandService implements CreditCommandService {

	@Inject
	private KieContainer kieContainer;

	@Inject
	private CreditReportRepository creditReportRepository;

	@Inject
	private CreditDecisionRepository creditDecisionRepository;

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public CreditReport pullCredit(Long applicationId) {
		CreditReport report = new CreditReport();
		report.setApplicationId(applicationId);
		report.setPullDate(new Date());
		return creditReportRepository.saveAndFlush(report);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public CreditDecision makeDecision(Long applicationId) {
		Optional<CreditReport> reportOpt = creditReportRepository.findByApplicationId(applicationId);
		CreditDecision decision = new CreditDecision();
		decision.setApplicationId(applicationId);

		if (reportOpt.isPresent()) {
			CreditReport report = reportOpt.get();
			try {
				KieSession kieSession = kieContainer.newKieSession();
				kieSession.setGlobal("decision", decision);
				kieSession.insert(report);
				kieSession.fireAllRules();
				kieSession.dispose();
			} catch (Exception e) {
				decision.setDecision("CONDITIONAL");
				decision.setConditions("Manual review required");
			}
		} else {
			decision.setDecision("DECLINED");
			decision.setConditions("No credit report found");
		}

		return creditDecisionRepository.saveAndFlush(decision);
	}

	@Override
	@Event(name = "sourcing")
	public double calculateDTI(Long applicationId) {
		Optional<CreditReport> reportOpt = creditReportRepository.findByApplicationId(applicationId);
		if (reportOpt.isPresent() && reportOpt.get().getTradelines() != null) {
			BigDecimal totalMonthlyDebt = reportOpt.get().getTradelines().stream()
					.map(t -> t.getMonthlyPayment() != null ? t.getMonthlyPayment() : BigDecimal.ZERO)
					.reduce(BigDecimal.ZERO, BigDecimal::add);
			return totalMonthlyDebt.doubleValue();
		}
		return 0.0;
	}

	@Override
	@Event(name = "sourcing")
	public double calculateLTV(Long applicationId) {
		return 0.0;
	}
}
