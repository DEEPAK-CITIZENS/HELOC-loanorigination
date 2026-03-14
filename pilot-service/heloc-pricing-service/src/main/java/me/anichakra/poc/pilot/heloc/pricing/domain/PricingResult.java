package me.anichakra.poc.pilot.heloc.pricing.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class PricingResult implements Serializable {

	private static final long serialVersionUID = 1L;

	private double baseRate;
	private double margin;
	private double apr;
	private BigDecimal maxLineAmount;
	private double promotionalRate;
	private String adjustments;

	public double getBaseRate() {
		return baseRate;
	}

	public void setBaseRate(double baseRate) {
		this.baseRate = baseRate;
	}

	public double getMargin() {
		return margin;
	}

	public void setMargin(double margin) {
		this.margin = margin;
	}

	public double getApr() {
		return apr;
	}

	public void setApr(double apr) {
		this.apr = apr;
	}

	public BigDecimal getMaxLineAmount() {
		return maxLineAmount;
	}

	public void setMaxLineAmount(BigDecimal maxLineAmount) {
		this.maxLineAmount = maxLineAmount;
	}

	public double getPromotionalRate() {
		return promotionalRate;
	}

	public void setPromotionalRate(double promotionalRate) {
		this.promotionalRate = promotionalRate;
	}

	public String getAdjustments() {
		return adjustments;
	}

	public void setAdjustments(String adjustments) {
		this.adjustments = adjustments;
	}
}
