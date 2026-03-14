package me.anichakra.poc.pilot.heloc.application.service.impl;

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
		return applicationRepository.saveAndFlush(application);
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
}
