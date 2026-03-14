package me.anichakra.poc.pilot.heloc.credit.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.credit.domain.CreditReport;
import me.anichakra.poc.pilot.heloc.credit.domain.Tradeline;
import me.anichakra.poc.pilot.heloc.credit.service.CreditQueryService;

@RestController
@RequestMapping("/credit")
public class CreditQueryController {

	@Inject
	private CreditQueryService creditQueryService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/report/{applicationId}")
	@ResponseBody
	public CreditReport getCreditReport(@PathVariable("applicationId") Long applicationId) {
		return creditQueryService.getCreditReport(applicationId).orElse(null);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/tradelines/{applicationId}")
	@ResponseBody
	public List<Tradeline> getTradelines(@PathVariable("applicationId") Long applicationId) {
		return creditQueryService.getTradelines(applicationId);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/dti/{applicationId}")
	@ResponseBody
	public double getDTI(@PathVariable("applicationId") Long applicationId) {
		return creditQueryService.getDTI(applicationId);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/ltv/{applicationId}")
	@ResponseBody
	public double getLTV(@PathVariable("applicationId") Long applicationId) {
		return creditQueryService.getLTV(applicationId);
	}
}
