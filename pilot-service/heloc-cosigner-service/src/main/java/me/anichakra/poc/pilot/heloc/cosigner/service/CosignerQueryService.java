package me.anichakra.poc.pilot.heloc.cosigner.service;

import java.util.List;
import java.util.Optional;

import me.anichakra.poc.pilot.heloc.cosigner.domain.Cosigner;

public interface CosignerQueryService {

	Optional<Cosigner> getCosigner(Long id);

	List<Cosigner> getCosignersByApplication(Long applicationId);
}
