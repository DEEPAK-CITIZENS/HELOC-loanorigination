package me.anichakra.poc.pilot.heloc.application.service;

import me.anichakra.poc.pilot.heloc.application.domain.LoanApplication;

public interface ApplicationCommandService {

	LoanApplication createApplication(LoanApplication application);

	LoanApplication updateApplication(LoanApplication application);

	LoanApplication submitApplication(Long applicationId);

	LoanApplication linkCosigner(Long applicationId, Long cosignerId);
}
