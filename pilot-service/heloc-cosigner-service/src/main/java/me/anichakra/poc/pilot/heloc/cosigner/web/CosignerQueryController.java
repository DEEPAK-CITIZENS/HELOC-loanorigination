package me.anichakra.poc.pilot.heloc.cosigner.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.cosigner.domain.Cosigner;
import me.anichakra.poc.pilot.heloc.cosigner.service.CosignerQueryService;

@RestController
@RequestMapping("/cosigner")
public class CosignerQueryController {

	@Inject
	private CosignerQueryService cosignerQueryService;

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/{id}")
	@ResponseBody
	public Cosigner getCosigner(@PathVariable("id") Long id) {
		return cosignerQueryService.getCosigner(id).orElse(null);
	}

	@ResponseStatus(HttpStatus.OK)
	@GetMapping("/application/{applicationId}")
	@ResponseBody
	public List<Cosigner> getCosignersByApplication(@PathVariable("applicationId") Long applicationId) {
		return cosignerQueryService.getCosignersByApplication(applicationId);
	}
}
