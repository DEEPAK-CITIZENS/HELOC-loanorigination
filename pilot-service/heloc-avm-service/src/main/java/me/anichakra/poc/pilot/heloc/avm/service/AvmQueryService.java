package me.anichakra.poc.pilot.heloc.avm.service;

import java.util.List;
import java.util.Optional;

import me.anichakra.poc.pilot.heloc.avm.domain.ValuationResult;

public interface AvmQueryService {

	Optional<ValuationResult> getValuation(Long id);

	List<ValuationResult> getValuationHistory(String propertyAddress);
}
