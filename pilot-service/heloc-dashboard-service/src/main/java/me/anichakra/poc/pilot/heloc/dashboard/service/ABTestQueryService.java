package me.anichakra.poc.pilot.heloc.dashboard.service;

import java.util.List;

import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTest;
import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTestResult;

public interface ABTestQueryService {

	List<ABTestResult> getTestResults(Long testId);

	List<ABTest> getActiveTests();
}
