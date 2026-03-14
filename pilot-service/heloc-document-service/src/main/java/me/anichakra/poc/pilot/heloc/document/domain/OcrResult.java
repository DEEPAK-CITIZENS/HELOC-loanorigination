package me.anichakra.poc.pilot.heloc.document.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

public class OcrResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private Map<String, String> extractedFields;
	private double confidence;
	private Date processedDate;

	public Map<String, String> getExtractedFields() {
		return extractedFields;
	}

	public void setExtractedFields(Map<String, String> extractedFields) {
		this.extractedFields = extractedFields;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	public Date getProcessedDate() {
		return processedDate;
	}

	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}
}
