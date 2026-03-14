package me.anichakra.poc.pilot.heloc.profile.service;

import java.util.List;
import java.util.Optional;

import me.anichakra.poc.pilot.heloc.profile.domain.BorrowerProfile;

public interface ProfileQueryService {

	Optional<BorrowerProfile> getProfile(Long id);

	List<BorrowerProfile> searchProfiles(String lastName);
}
