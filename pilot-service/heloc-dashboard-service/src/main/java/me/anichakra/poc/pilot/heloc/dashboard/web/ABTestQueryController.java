package me.anichakra.poc.pilot.heloc.dashboard.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTest;
import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTestResult;
import me.anichakra.poc.pilot.heloc.dashboard.service.ABTestQueryService;

@RestController
@RequestMapping("/abtest")
public class ABTestQueryController {

	@Inject
	private ABTestQueryService abTestQueryService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}/results")
	@ResponseBody
	public List<ABTestResult> getTestResults(@PathVariable("id") Long id) {
		return abTestQueryService.getTestResults(id);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/active")
	@ResponseBody
	public List<ABTest> getActiveTests() {
		return abTestQueryService.getActiveTests();
	}
}
