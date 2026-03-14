package me.anichakra.poc.pilot.heloc.dashboard.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTest;
import me.anichakra.poc.pilot.heloc.dashboard.domain.ABTestResult;
import me.anichakra.poc.pilot.heloc.dashboard.service.ABTestCommandService;

@RestController
@RequestMapping("/abtest")
public class ABTestCommandController {

	@Inject
	private ABTestCommandService abTestCommandService;

	@PostMapping("/create")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ABTest createTest(@RequestBody ABTest test) {
		return abTestCommandService.createTest(test);
	}

	@PostMapping("/{id}/convert")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public ABTestResult recordConversion(@PathVariable("id") Long id, @RequestParam("variant") String variant) {
		return abTestCommandService.recordConversion(id, variant);
	}
}
