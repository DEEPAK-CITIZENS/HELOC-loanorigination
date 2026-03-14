package me.anichakra.poc.pilot.heloc.credit.service;

import java.util.List;
import java.util.Optional;

import me.anichakra.poc.pilot.heloc.credit.domain.CreditDecision;
import me.anichakra.poc.pilot.heloc.credit.domain.CreditReport;
import me.anichakra.poc.pilot.heloc.credit.domain.Tradeline;

public interface CreditQueryService {

	Optional<CreditReport> getCreditReport(Long applicationId);

	Optional<CreditDecision> getDecision(Long applicationId);

	List<Tradeline> getTradelines(Long applicationId);

	double getDTI(Long applicationId);

	double getLTV(Long applicationId);
}
