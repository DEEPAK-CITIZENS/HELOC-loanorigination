package me.anichakra.poc.pilot.heloc.credit.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

public class PropertyValuation implements Serializable {

	private static final long serialVersionUID = 1L;

	private String propertyAddress;
	private BigDecimal estimatedValue;
	private double confidence;
	private Date valuationDate;

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public BigDecimal getEstimatedValue() {
		return estimatedValue;
	}

	public void setEstimatedValue(BigDecimal estimatedValue) {
		this.estimatedValue = estimatedValue;
	}

	public double getConfidence() {
		return confidence;
	}

	public void setConfidence(double confidence) {
		this.confidence = confidence;
	}

	public Date getValuationDate() {
		return valuationDate;
	}

	public void setValuationDate(Date valuationDate) {
		this.valuationDate = valuationDate;
	}
}
