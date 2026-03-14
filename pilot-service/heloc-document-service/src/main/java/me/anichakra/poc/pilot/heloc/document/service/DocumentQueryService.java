package me.anichakra.poc.pilot.heloc.document.service;

import java.util.List;
import java.util.Optional;

import me.anichakra.poc.pilot.heloc.document.domain.Document;
import me.anichakra.poc.pilot.heloc.document.domain.OcrResult;

public interface DocumentQueryService {

	Optional<Document> getDocument(String id);

	List<Document> getDocumentsByApplication(Long applicationId);

	OcrResult getOcrResult(String documentId);
}
