package me.anichakra.poc.pilot.heloc.dashboard.service;

import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTest;
import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTestResult;

public interface ABTestCommandService {

	ABTest createTest(ABTest test);

	String assignVariant(Long testId);

	ABTestResult recordConversion(Long testId, String variant);
}
