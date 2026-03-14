package me.anichakra.poc.pilot.heloc.dashboard.service;

import java.util.List;

import me.anichakra.poc.pilot.heloc.dashboard.domain.DashboardMetric;

public interface DashboardQueryService {

	List<DashboardMetric> getPerformanceMetrics(String period);

	List<DashboardMetric> getConversionFunnel();

	List<DashboardMetric> getLoanVolume(String period);

	List<DashboardMetric> getAverageCycleTime();
}
