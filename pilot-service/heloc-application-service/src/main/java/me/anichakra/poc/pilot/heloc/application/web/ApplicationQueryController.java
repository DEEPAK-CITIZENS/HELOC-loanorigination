package me.anichakra.poc.pilot.heloc.application.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.application.domain.LoanApplication;
import me.anichakra.poc.pilot.heloc.application.domain.ProgressStage;
import me.anichakra.poc.pilot.heloc.application.service.ApplicationQueryService;

@RestController
@RequestMapping("/application")
public class ApplicationQueryController {

	@Inject
	private ApplicationQueryService applicationQueryService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	@ResponseBody
	public LoanApplication getApplication(@PathVariable("id") Long id) {
		return applicationQueryService.getApplication(id).orElse(null);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/borrower/{borrowerId}")
	@ResponseBody
	public List<LoanApplication> getApplicationsByBorrower(@PathVariable("borrowerId") Long borrowerId) {
		return applicationQueryService.getApplicationsByBorrower(borrowerId);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}/progress")
	@ResponseBody
	public ProgressStage getApplicationProgress(@PathVariable("id") Long id) {
		return applicationQueryService.getApplicationProgress(id);
	}
}
