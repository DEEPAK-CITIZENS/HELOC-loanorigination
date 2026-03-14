package me.anichakra.poc.pilot.heloc.application.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.QueryService;
import me.anichakra.poc.pilot.heloc.application.domain.ApplicationStatus;
import me.anichakra.poc.pilot.heloc.application.domain.LoanApplication;
import me.anichakra.poc.pilot.heloc.application.domain.ProgressStage;
import me.anichakra.poc.pilot.heloc.application.repo.ApplicationRepository;
import me.anichakra.poc.pilot.heloc.application.service.ApplicationQueryService;

@QueryService
public class DefaultApplicationQueryService implements ApplicationQueryService {

	@Inject
	private ApplicationRepository applicationRepository;

	@Override
	@Event(name = "tracing")
	public Optional<LoanApplication> getApplication(Long id) {
		return applicationRepository.findById(id);
	}

	@Override
	@Event(name = "tracing")
	public List<LoanApplication> getApplicationsByBorrower(Long borrowerId) {
		return applicationRepository.findByBorrowerId(borrowerId);
	}

	@Override
	@Event(name = "tracing")
	public ProgressStage getApplicationProgress(Long applicationId) {
		Optional<LoanApplication> application = applicationRepository.findById(applicationId);
		return application.map(LoanApplication::getProgressStage).orElse(null);
	}

	@Override
	@Event(name = "tracing")
	public List<LoanApplication> searchApplications(String status) {
		if (status != null) {
			return applicationRepository.findAll();
		}
		return applicationRepository.findAll();
	}
}
