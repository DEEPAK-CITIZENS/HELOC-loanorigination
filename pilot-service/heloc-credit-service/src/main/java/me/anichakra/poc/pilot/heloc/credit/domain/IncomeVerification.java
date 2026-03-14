package me.anichakra.poc.pilot.heloc.credit.domain;

import java.io.Serializable;
import java.math.BigDecimal;

public class IncomeVerification implements Serializable {

	private static final long serialVersionUID = 1L;

	private BigDecimal monthlyIncome;
	private String employerName;
	private String verificationSource;

	public BigDecimal getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(BigDecimal monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public String getEmployerName() {
		return employerName;
	}

	public void setEmployerName(String employerName) {
		this.employerName = employerName;
	}

	public String getVerificationSource() {
		return verificationSource;
	}

	public void setVerificationSource(String verificationSource) {
		this.verificationSource = verificationSource;
	}
}
