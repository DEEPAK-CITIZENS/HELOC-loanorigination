package me.anichakra.poc.pilot.heloc.profile.service;

import me.anichakra.poc.pilot.heloc.profile.domain.BorrowerProfile;

public interface ProfileCommandService {

	BorrowerProfile createProfile(BorrowerProfile profile);

	BorrowerProfile verifyWithProve(Long profileId);

	BorrowerProfile updateProfile(BorrowerProfile profile);
}
