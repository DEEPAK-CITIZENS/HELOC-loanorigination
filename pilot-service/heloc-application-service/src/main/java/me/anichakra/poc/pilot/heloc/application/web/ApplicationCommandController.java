package me.anichakra.poc.pilot.heloc.application.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.application.domain.LoanApplication;
import me.anichakra.poc.pilot.heloc.application.service.ApplicationCommandService;

@RestController
@RequestMapping("/application")
public class ApplicationCommandController {

	@Inject
	private ApplicationCommandService applicationCommandService;

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public LoanApplication createApplication(@RequestBody LoanApplication application) {
		return applicationCommandService.createApplication(application);
	}

	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public LoanApplication updateApplication(@PathVariable("id") Long id, @RequestBody LoanApplication application) {
		application.setId(id);
		return applicationCommandService.updateApplication(application);
	}

	@PostMapping("/{id}/submit")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public LoanApplication submitApplication(@PathVariable("id") Long id) {
		return applicationCommandService.submitApplication(id);
	}

	@PostMapping("/{id}/cosigner")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public LoanApplication linkCosigner(@PathVariable("id") Long id, @RequestBody Long cosignerId) {
		return applicationCommandService.linkCosigner(id, cosignerId);
	}
}
