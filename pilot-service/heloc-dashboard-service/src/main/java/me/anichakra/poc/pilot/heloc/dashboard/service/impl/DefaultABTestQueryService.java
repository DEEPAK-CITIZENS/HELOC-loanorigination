package me.anichakra.poc.pilot.heloc.dashboard.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.QueryService;
import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTest;
import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTestResult;
import me.anichakra.poc.pilot.heloc.dashboard.repo.ABTestRepository;
import me.anichakra.poc.pilot.heloc.dashboard.repo.ABTestResultRepository;
import me.anichakra.poc.pilot.heloc.dashboard.service.ABTestQueryService;

@QueryService
public class DefaultABTestQueryService implements ABTestQueryService {

	@Inject
	private ABTestResultRepository abTestResultRepository;

	@Inject
	private ABTestRepository abTestRepository;

	@Override
	@Event(name = "tracing")
	public List<ABTestResult> getTestResults(Long testId) {
		return abTestResultRepository.findByTestId(testId);
	}

	@Override
	@Event(name = "tracing")
	public List<ABTest> getActiveTests() {
		return abTestRepository.findByStatus("ACTIVE");
	}
}
