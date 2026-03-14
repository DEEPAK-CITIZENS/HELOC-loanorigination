package me.anichakra.poc.pilot.heloc.document.service.impl;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.QueryService;
import me.anichakra.poc.pilot.heloc.document.domain.Document;
import me.anichakra.poc.pilot.heloc.document.domain.OcrResult;
import me.anichakra.poc.pilot.heloc.document.repo.DocumentRepository;
import me.anichakra.poc.pilot.heloc.document.service.DocumentQueryService;

@QueryService
public class DefaultDocumentQueryService implements DocumentQueryService {

	@Inject
	private DocumentRepository documentRepository;

	@Override
	@Event(name = "tracing")
	public Optional<Document> getDocument(String id) {
		return documentRepository.findById(id);
	}

	@Override
	@Event(name = "tracing")
	public List<Document> getDocumentsByApplication(Long applicationId) {
		return documentRepository.findByApplicationId(applicationId);
	}

	@Override
	@Event(name = "tracing")
	public OcrResult getOcrResult(String documentId) {
		Optional<Document> document = documentRepository.findById(documentId);
		return document.map(Document::getOcrResult).orElse(null);
	}
}
