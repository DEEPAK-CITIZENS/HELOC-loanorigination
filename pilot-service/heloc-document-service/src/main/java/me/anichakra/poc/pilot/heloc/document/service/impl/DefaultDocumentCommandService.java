package me.anichakra.poc.pilot.heloc.document.service.impl;

import java.util.Date;

import javax.inject.Inject;

import me.anichakra.poc.pilot.framework.annotation.CommandService;
import me.anichakra.poc.pilot.framework.annotation.Event;
import me.anichakra.poc.pilot.framework.annotation.EventObject;
import me.anichakra.poc.pilot.heloc.document.domain.Document;
import me.anichakra.poc.pilot.heloc.document.repo.DocumentRepository;
import me.anichakra.poc.pilot.heloc.document.service.DocumentCommandService;

@CommandService
public class DefaultDocumentCommandService implements DocumentCommandService {

	@Inject
	private DocumentRepository documentRepository;

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public Document uploadDocument(Document document) {
		document.setUploadDate(new Date());
		document.setStatus("UPLOADED");
		return documentRepository.save(document);
	}

	@Override
	@Event(name = "sourcing", object = EventObject.RESPONSE)
	public Document processOcr(String documentId) {
		Document document = documentRepository.findById(documentId).get();
		document.setStatus("OCR_PROCESSED");
		return documentRepository.save(document);
	}

	@Override
	@Event(name = "sourcing")
	public void deleteDocument(String documentId) {
		documentRepository.deleteById(documentId);
	}
}
