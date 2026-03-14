package me.anichakra.poc.pilot.heloc.avm.service.impl;

import java.util.Date;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.CommandService;
import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.EventObject;
import me.anichakra.poc.pilot.heloc.avm.domain.ValuationRequest;
import me.anichakra.poc.pilot.heloc.avm.domain.ValuationResult;
import me.anichakra.poc.pilot.heloc.avm.repo.ValuationResultRepository;
import me.anichakra.poc.pilot.heloc.avm.service.AvmCommandService;

@CommandService
public class DefaultAvmCommandService implements AvmCommandService {

	@Inject
	private ValuationResultRepository valuationResultRepository;

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public ValuationResult requestValuation(ValuationRequest request) {
		ValuationResult result = new ValuationResult();
		result.setPropertyAddress(request.getPropertyAddress());
		result.setValuationDate(new Date());
		return valuationResultRepository.saveAndFlush(result);
	}
}
