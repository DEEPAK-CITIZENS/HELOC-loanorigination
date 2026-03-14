package me.anichakra.poc.pilot.heloc.avm.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.avm.domain.ValuationRequest;
import me.anichakra.poc.pilot.heloc.avm.domain.ValuationResult;
import me.anichakra.poc.pilot.heloc.avm.service.AvmCommandService;

@RestController
@RequestMapping("/valuation")
public class AvmCommandController {

	@Inject
	private AvmCommandService avmCommandService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public ValuationResult requestValuation(@RequestBody ValuationRequest request) {
		return avmCommandService.requestValuation(request);
	}
}
