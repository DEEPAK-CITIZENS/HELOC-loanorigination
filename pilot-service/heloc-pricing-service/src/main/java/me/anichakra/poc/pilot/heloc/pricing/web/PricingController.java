package me.anichakra.poc.pilot.heloc.pricing.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.pricing.domain.PricingRequest;
import me.anichakra.poc.pilot.heloc.pricing.domain.PricingResult;
import me.anichakra.poc.pilot.heloc.pricing.service.PricingQueryService;

@RestController
@RequestMapping("/pricing")
public class PricingController {

	@Inject
	private PricingQueryService pricingQueryService;

	@PostMapping("/calculate")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public PricingResult calculatePricing(@RequestBody PricingRequest request) {
		return pricingQueryService.calculatePricing(request);
	}

	@GetMapping("/rate")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public double getRate(@RequestParam("creditScore") int creditScore, @RequestParam("ltv") double ltv) {
		return pricingQueryService.getRate(creditScore, ltv);
	}
}
