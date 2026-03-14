package me.anichakra.poc.pilot.heloc.pricing.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class PricingRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private int creditScore;
	private double ltv;
	private double dti;
	private String state;
	private BigDecimal loanAmount;
	private String propertyType;

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public double getLtv() {
		return ltv;
	}

	public void setLtv(double ltv) {
		this.ltv = ltv;
	}

	public double getDti() {
		return dti;
	}

	public void setDti(double dti) {
		this.dti = dti;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getPropertyType() {
		return propertyType;
	}

	public void setPropertyType(String propertyType) {
		this.propertyType = propertyType;
	}
}
