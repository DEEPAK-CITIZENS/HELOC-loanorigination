package me.anichakra.poc.pilot.heloc.document.web;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.document.domain.Document;
import me.anichakra.poc.pilot.heloc.document.service.DocumentCommandService;

@RestController
@RequestMapping("/document")
public class DocumentController {

	@Inject
	private DocumentCommandService documentCommandService;

	@PostMapping("/upload")
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public Document uploadDocument(@RequestBody Document document) {
		return documentCommandService.uploadDocument(document);
	}
}
