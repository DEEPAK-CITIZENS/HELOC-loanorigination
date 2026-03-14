package me.anichakra.poc.pilot.heloc.dashboard.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.dashboard.domain.DashboardMetric;
import me.anichakra.poc.pilot.heloc.dashboard.service.DashboardQueryService;

@RestController
@RequestMapping("/dashboard")
public class DashboardQueryController {

	@Inject
	private DashboardQueryService dashboardQueryService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/metrics")
	@ResponseBody
	public List<DashboardMetric> getPerformanceMetrics(@RequestParam(value = "period", defaultValue = "monthly") String period) {
		return dashboardQueryService.getPerformanceMetrics(period);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/funnel")
	@ResponseBody
	public List<DashboardMetric> getConversionFunnel() {
		return dashboardQueryService.getConversionFunnel();
	}
}
