package me.anichakra.poc.pilot.heloc.profile.service.impl;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.CommandService;
import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.EventObject;
import me.anichakra.poc.pilot.heloc.profile.domain.BorrowerProfile;
import me.anichakra.poc.pilot.heloc.profile.repo.BorrowerProfileRepository;
import me.anichakra.poc.pilot.heloc.profile.service.ProfileCommandService;

@CommandService
public class DefaultProfileCommandService implements ProfileCommandService {

	@Inject
	private BorrowerProfileRepository borrowerProfileRepository;

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public BorrowerProfile createProfile(BorrowerProfile profile) {
		return borrowerProfileRepository.saveAndFlush(profile);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public BorrowerProfile verifyWithProve(Long profileId) {
		BorrowerProfile profile = borrowerProfileRepository.findById(profileId).get();
		profile.setProveVerified(true);
		return borrowerProfileRepository.saveAndFlush(profile);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public BorrowerProfile updateProfile(BorrowerProfile profile) {
		return borrowerProfileRepository.saveAndFlush(profile);
	}
}
