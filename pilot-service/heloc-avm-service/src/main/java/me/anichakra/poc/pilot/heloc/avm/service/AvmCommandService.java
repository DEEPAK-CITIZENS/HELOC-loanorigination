package me.anichakra.poc.pilot.heloc.avm.service;

import me.anichakra.poc.pilot.heloc.avm.domain.ValuationRequest;
import me.anichakra.poc.pilot.heloc.avm.domain.ValuationResult;

public interface AvmCommandService {

	ValuationResult requestValuation(ValuationRequest request);
}
