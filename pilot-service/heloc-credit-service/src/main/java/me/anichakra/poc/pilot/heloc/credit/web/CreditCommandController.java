package me.anichakra.poc.pilot.heloc.credit.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.credit.domain.CreditDecision;
import me.anichakra.poc.pilot.heloc.credit.domain.CreditReport;
import me.anichakra.poc.pilot.heloc.credit.service.CreditCommandService;

@RestController
@RequestMapping("/credit")
public class CreditCommandController {

	@Inject
	private CreditCommandService creditCommandService;

	@PostMapping("/pull/{applicationId}")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public CreditReport pullCredit(@PathVariable("applicationId") Long applicationId) {
		return creditCommandService.pullCredit(applicationId);
	}

	@PostMapping("/decision/{applicationId}")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public CreditDecision makeDecision(@PathVariable("applicationId") Long applicationId) {
		return creditCommandService.makeDecision(applicationId);
	}
}
