package me.anichakra.poc.pilot.heloc.profile.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.QueryService;
import me.anichakra.poc.pilot.heloc.profile.domain.BorrowerProfile;
import me.anichakra.poc.pilot.heloc.profile.repo.BorrowerProfileRepository;
import me.anichakra.poc.pilot.heloc.profile.service.ProfileQueryService;

@QueryService
public class DefaultProfileQueryService implements ProfileQueryService {

	@Inject
	private BorrowerProfileRepository borrowerProfileRepository;

	@Override
	@Event(name = "tracing")
	public Optional<BorrowerProfile> getProfile(Long id) {
		return borrowerProfileRepository.findById(id);
	}

	@Override
	@Event(name = "tracing")
	public List<BorrowerProfile> searchProfiles(String lastName) {
		return borrowerProfileRepository.findByLastName(lastName);
	}
}
