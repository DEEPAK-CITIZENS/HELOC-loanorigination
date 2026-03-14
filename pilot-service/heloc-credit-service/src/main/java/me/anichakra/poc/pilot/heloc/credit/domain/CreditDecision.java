package me.anichakra.poc.pilot.heloc.credit.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class CreditDecision implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Long applicationId;
	private String decision;
	private String conditions;
	private BigDecimal maxLineAmount;
	private double dti;
	private double ltv;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(Long applicationId) {
		this.applicationId = applicationId;
	}

	public String getDecision() {
		return decision;
	}

	public void setDecision(String decision) {
		this.decision = decision;
	}

	public String getConditions() {
		return conditions;
	}

	public void setConditions(String conditions) {
		this.conditions = conditions;
	}

	public BigDecimal getMaxLineAmount() {
		return maxLineAmount;
	}

	public void setMaxLineAmount(BigDecimal maxLineAmount) {
		this.maxLineAmount = maxLineAmount;
	}

	public double getDti() {
		return dti;
	}

	public void setDti(double dti) {
		this.dti = dti;
	}

	public double getLtv() {
		return ltv;
	}

	public void setLtv(double ltv) {
		this.ltv = ltv;
	}
}
