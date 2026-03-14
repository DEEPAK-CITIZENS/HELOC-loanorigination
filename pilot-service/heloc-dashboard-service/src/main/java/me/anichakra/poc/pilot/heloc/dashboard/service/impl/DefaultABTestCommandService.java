package me.anichakra.poc.pilot.heloc.dashboard.service.impl;

import java.util.Date;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.CommandService;
import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.EventObject;
import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTest;
import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTestResult;
import me.anichakra.poc.pilot.heloc.dashboard.repo.ABTestRepository;
import me.anichakra.poc.pilot.heloc.dashboard.repo.ABTestResultRepository;
import me.anichakra.poc.pilot.heloc.dashboard.service.ABTestCommandService;

@CommandService
public class DefaultABTestCommandService implements ABTestCommandService {

	@Inject
	private ABTestRepository abTestRepository;

	@Inject
	private ABTestResultRepository abTestResultRepository;

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public ABTest createTest(ABTest test) {
		test.setStartDate(new Date());
		test.setStatus("ACTIVE");
		return abTestRepository.saveAndFlush(test);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public String assignVariant(Long testId) {
		ABTest test = abTestRepository.findById(testId).get();
		int variantIndex = (int) (Math.random() * test.getVariants().size());
		return test.getVariants().get(variantIndex);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public ABTestResult recordConversion(Long testId, String variant) {
		ABTestResult result = new ABTestResult();
		result.setTestId(testId);
		result.setVariant(variant);
		return abTestResultRepository.saveAndFlush(result);
	}
}
