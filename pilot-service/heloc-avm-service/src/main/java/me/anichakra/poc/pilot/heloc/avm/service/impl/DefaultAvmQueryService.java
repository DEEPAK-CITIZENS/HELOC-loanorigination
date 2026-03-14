package me.anichakra.poc.pilot.heloc.avm.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.QueryService;
import me.anichakra.poc.pilot.heloc.avm.domain.ValuationResult;
import me.anichakra.poc.pilot.heloc.avm.repo.ValuationResultRepository;
import me.anichakra.poc.pilot.heloc.avm.service.AvmQueryService;

@QueryService
public class DefaultAvmQueryService implements AvmQueryService {

	@Inject
	private ValuationResultRepository valuationResultRepository;

	@Override
	@Event(name = "tracing")
	public Optional<ValuationResult> getValuation(Long id) {
		return valuationResultRepository.findById(id);
	}

	@Override
	@Event(name = "tracing")
	public List<ValuationResult> getValuationHistory(String propertyAddress) {
		return valuationResultRepository.findByPropertyAddress(propertyAddress);
	}
}
