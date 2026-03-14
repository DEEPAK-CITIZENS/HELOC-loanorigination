package me.anichakra.poc.pilot.heloc.credit.service;

import me.anichakra.poc.pilot.heloc.credit.domain.CreditDecision;
import me.anichakra.poc.pilot.heloc.credit.domain.CreditReport;

public interface CreditCommandService {

	CreditReport pullCredit(Long applicationId);

	CreditDecision makeDecision(Long applicationId);

	double calculateDTI(Long applicationId);

	double calculateLTV(Long applicationId);
}
