package me.anichakra.poc.pilot.heloc.cosigner.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.QueryService;
import me.anichakra.poc.pilot.heloc.cosigner.domain.Cosigner;
import me.anichakra.poc.pilot.heloc.cosigner.repo.CosignerRepository;
import me.anichakra.poc.pilot.heloc.cosigner.service.CosignerQueryService;

@QueryService
public class DefaultCosignerQueryService implements CosignerQueryService {

	@Inject
	private CosignerRepository cosignerRepository;

	@Override
	@Event(name = "tracing")
	public Optional<Cosigner> getCosigner(Long id) {
		return cosignerRepository.findById(id);
	}

	@Override
	@Event(name = "tracing")
	public List<Cosigner> getCosignersByApplication(Long applicationId) {
		return cosignerRepository.findByPrimaryApplicationId(applicationId);
	}
}
