package me.anichakra.poc.pilot.heloc.document.service;

import me.anichakra.poc.pilot.heloc.document.domain.Document;

public interface DocumentCommandService {

	Document uploadDocument(Document document);

	Document processOcr(String documentId);

	void deleteDocument(String documentId);
}
