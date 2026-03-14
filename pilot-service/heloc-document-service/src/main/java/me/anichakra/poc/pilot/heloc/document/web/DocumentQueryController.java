package me.anichakra.poc.pilot.heloc.document.web;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import me.anichakra.poc.pilot.heloc.document.domain.Document;
import me.anichakra.poc.pilot.heloc.document.domain.OcrResult;
import me.anichakra.poc.pilot.heloc.document.service.DocumentQueryService;

@RestController
@RequestMapping("/document")
public class DocumentQueryController {

	@Inject
	private DocumentQueryService documentQueryService;

	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public Document getDocument(@PathVariable("id") String id) {
		return documentQueryService.getDocument(id).orElse(null);
	}

	@GetMapping("/application/{applicationId}")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public List<Document> getDocumentsByApplication(@PathVariable("applicationId") Long applicationId) {
		return documentQueryService.getDocumentsByApplication(applicationId);
	}

	@GetMapping("/{id}/ocr")
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	public OcrResult getOcrResult(@PathVariable("id") String id) {
		return documentQueryService.getOcrResult(id);
	}
}
