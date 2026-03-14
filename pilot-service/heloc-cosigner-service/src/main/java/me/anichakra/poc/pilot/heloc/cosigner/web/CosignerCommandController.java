package me.anichakra.poc.pilot.heloc.cosigner.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.cosigner.domain.Cosigner;
import me.anichakra.poc.pilot.heloc.cosigner.service.CosignerCommandService;

@RestController
@RequestMapping("/cosigner")
public class CosignerCommandController {

	@Inject
	private CosignerCommandService cosignerCommandService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Cosigner addCosigner(@RequestBody Cosigner cosigner) {
		return cosignerCommandService.addCosigner(cosigner);
	}

	@PostMapping("/{id}/consent")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Cosigner recordConsent(@PathVariable("id") Long id) {
		return cosignerCommandService.recordConsent(id);
	}

	@PostMapping("/{id}/credit")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Cosigner pullCosignerCredit(@PathVariable("id") Long id) {
		return cosignerCommandService.pullCosignerCredit(id);
	}
}
