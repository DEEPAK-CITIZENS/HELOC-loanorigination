package me.anichakra.poc.pilot.heloc.document.domain;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.annotation.Id;

@org.springframework.data.mongodb.core.mapping.Document(collection = "document")
public class Document implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private Long applicationId;
	private String documentType;
	private String fileName;
	private String s3Key;
	private Date uploadDate;
	private OcrResult ocrResult;
	private String status;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getS3Key() {
		return s3Key;
	}

	public void setS3Key(String s3Key) {
		this.s3Key = s3Key;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public OcrResult getOcrResult() {
		return ocrResult;
	}

	public void setOcrResult(OcrResult ocrResult) {
		this.ocrResult = ocrResult;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
