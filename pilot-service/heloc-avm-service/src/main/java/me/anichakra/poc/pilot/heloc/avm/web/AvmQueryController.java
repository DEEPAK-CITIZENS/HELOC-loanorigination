package me.anichakra.poc.pilot.heloc.avm.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.avm.domain.ValuationResult;
import me.anichakra.poc.pilot.heloc.avm.service.AvmQueryService;

@RestController
@RequestMapping("/valuation")
public class AvmQueryController {

	@Inject
	private AvmQueryService avmQueryService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	@ResponseBody
	public ValuationResult getValuation(@PathVariable("id") Long id) {
		return avmQueryService.getValuation(id).orElse(null);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/history")
	@ResponseBody
	public List<ValuationResult> getValuationHistory(@RequestParam("propertyAddress") String propertyAddress) {
		return avmQueryService.getValuationHistory(propertyAddress);
	}
}
