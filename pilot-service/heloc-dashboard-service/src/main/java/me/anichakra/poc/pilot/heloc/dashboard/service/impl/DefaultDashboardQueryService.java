package me.anichakra.poc.pilot.heloc.dashboard.service.impl;

import java.util.List;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.QueryService;
import me.anichakra.poc.pilot.heloc.dashboard.domain.DashboardMetric;
import me.anichakra.poc.pilot.heloc.dashboard.repo.DashboardMetricRepository;
import me.anichakra.poc.pilot.heloc.dashboard.service.DashboardQueryService;

@QueryService
public class DefaultDashboardQueryService implements DashboardQueryService {

	@Inject
	private DashboardMetricRepository dashboardMetricRepository;

	@Override
	@Event(name = "tracing")
	public List<DashboardMetric> getPerformanceMetrics(String period) {
		return dashboardMetricRepository.findByPeriod(period);
	}

	@Override
	@Event(name = "tracing")
	public List<DashboardMetric> getConversionFunnel() {
		return dashboardMetricRepository.findByMetricName("conversion_funnel");
	}

	@Override
	@Event(name = "tracing")
	public List<DashboardMetric> getLoanVolume(String period) {
		return dashboardMetricRepository.findByMetricName("loan_volume");
	}

	@Override
	@Event(name = "tracing")
	public List<DashboardMetric> getAverageCycleTime() {
		return dashboardMetricRepository.findByMetricName("avg_cycle_time");
	}
}
