package me.anichakra.poc.pilot.heloc.application.service;

import java.util.List;
import java.util.Optional;

import me.anichakra.poc.pilot.heloc.application.domain.LoanApplication;
import me.anichakra.poc.pilot.heloc.application.domain.ProgressStage;

public interface ApplicationQueryService {

	Optional<LoanApplication> getApplication(Long id);

	List<LoanApplication> getApplicationsByBorrower(Long borrowerId);

	ProgressStage getApplicationProgress(Long applicationId);

	List<LoanApplication> searchApplications(String status);
}
