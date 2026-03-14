package me.anichakra.poc.pilot.heloc.credit.service.impl;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.QueryService;
import me.anichakra.poc.pilot.heloc.credit.domain.CreditDecision;
import me.anichakra.poc.pilot.heloc.credit.domain.CreditReport;
import me.anichakra.poc.pilot.heloc.credit.domain.Tradeline;
import me.anichakra.poc.pilot.heloc.credit.repo.CreditDecisionRepository;
import me.anichakra.poc.pilot.heloc.credit.repo.CreditReportRepository;
import me.anichakra.poc.pilot.heloc.credit.service.CreditQueryService;

@QueryService
public class DefaultCreditQueryService implements CreditQueryService {

	@Inject
	private CreditReportRepository creditReportRepository;

	@Inject
	private CreditDecisionRepository creditDecisionRepository;

	@Override
	@Event(name = "tracing")
	public Optional<CreditReport> getCreditReport(Long applicationId) {
		return creditReportRepository.findByApplicationId(applicationId);
	}

	@Override
	@Event(name = "tracing")
	public Optional<CreditDecision> getDecision(Long applicationId) {
		return creditDecisionRepository.findByApplicationId(applicationId);
	}

	@Override
	@Event(name = "tracing")
	public List<Tradeline> getTradelines(Long applicationId) {
		Optional<CreditReport> report = creditReportRepository.findByApplicationId(applicationId);
		return report.map(CreditReport::getTradelines).orElse(Collections.emptyList());
	}

	@Override
	@Event(name = "tracing")
	public double getDTI(Long applicationId) {
		Optional<CreditDecision> decision = creditDecisionRepository.findByApplicationId(applicationId);
		return decision.map(CreditDecision::getDti).orElse(0.0);
	}

	@Override
	@Event(name = "tracing")
	public double getLTV(Long applicationId) {
		Optional<CreditDecision> decision = creditDecisionRepository.findByApplicationId(applicationId);
		return decision.map(CreditDecision::getLtv).orElse(0.0);
	}
}
