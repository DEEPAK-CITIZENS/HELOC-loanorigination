package me.anichakra.poc.pilot.heloc.application.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class LoanApplication implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Long borrowerId;
	private Long cosignerId;
	private BigDecimal loanAmount;
	private String propertyAddress;

	@Enumerated(EnumType.STRING)
	private ApplicationStatus applicationStatus;

	@Enumerated(EnumType.STRING)
	private ProgressStage progressStage;

	private Date createdDate;
	private Date updatedDate;

	// ── Credit Decisioning (Experian Mock) ──────────────────────────────────
	private Integer creditScore;
	private Double dti;
	private Double cltv;
	private Double interestRate;
	private String creditDecision;
	@Column(length = 1000)
	private String creditDecisionReasons;

	// ── Open Banking (Argyle Integration) ───────────────────────────────────
	private String bankName;
	private String maskedAccountNumber;
	private BigDecimal monthlyIncome;
	private BigDecimal monthlyExpenses;
	private Integer cashflowScore;
	private Boolean autopayEnrolled;

	// ── Property Appraisal (AVM Integration) ────────────────────────────────
	private BigDecimal appraisedValue;
	private Double avmConfidence;
	private Date appraisalDate;

	// ── Underwriting ────────────────────────────────────────────────────────
	private String underwritingStatus;
	@Column(length = 2000)
	private String underwritingNotes;
	private BigDecimal approvedCreditLine;
	private BigDecimal monthlyPayment;

	// ── Getters and Setters ─────────────────────────────────────────────────

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBorrowerId() {
		return borrowerId;
	}

	public void setBorrowerId(Long borrowerId) {
		this.borrowerId = borrowerId;
	}

	public Long getCosignerId() {
		return cosignerId;
	}

	public void setCosignerId(Long cosignerId) {
		this.cosignerId = cosignerId;
	}

	public BigDecimal getLoanAmount() {
		return loanAmount;
	}

	public void setLoanAmount(BigDecimal loanAmount) {
		this.loanAmount = loanAmount;
	}

	public String getPropertyAddress() {
		return propertyAddress;
	}

	public void setPropertyAddress(String propertyAddress) {
		this.propertyAddress = propertyAddress;
	}

	public ApplicationStatus getApplicationStatus() {
		return applicationStatus;
	}

	public void setApplicationStatus(ApplicationStatus applicationStatus) {
		this.applicationStatus = applicationStatus;
	}

	public ProgressStage getProgressStage() {
		return progressStage;
	}

	public void setProgressStage(ProgressStage progressStage) {
		this.progressStage = progressStage;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public Integer getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(Integer creditScore) {
		this.creditScore = creditScore;
	}

	public Double getDti() {
		return dti;
	}

	public void setDti(Double dti) {
		this.dti = dti;
	}

	public Double getCltv() {
		return cltv;
	}

	public void setCltv(Double cltv) {
		this.cltv = cltv;
	}

	public Double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(Double interestRate) {
		this.interestRate = interestRate;
	}

	public String getCreditDecision() {
		return creditDecision;
	}

	public void setCreditDecision(String creditDecision) {
		this.creditDecision = creditDecision;
	}

	public String getCreditDecisionReasons() {
		return creditDecisionReasons;
	}

	public void setCreditDecisionReasons(String creditDecisionReasons) {
		this.creditDecisionReasons = creditDecisionReasons;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	public String getMaskedAccountNumber() {
		return maskedAccountNumber;
	}

	public void setMaskedAccountNumber(String maskedAccountNumber) {
		this.maskedAccountNumber = maskedAccountNumber;
	}

	public BigDecimal getMonthlyIncome() {
		return monthlyIncome;
	}

	public void setMonthlyIncome(BigDecimal monthlyIncome) {
		this.monthlyIncome = monthlyIncome;
	}

	public BigDecimal getMonthlyExpenses() {
		return monthlyExpenses;
	}

	public void setMonthlyExpenses(BigDecimal monthlyExpenses) {
		this.monthlyExpenses = monthlyExpenses;
	}

	public Integer getCashflowScore() {
		return cashflowScore;
	}

	public void setCashflowScore(Integer cashflowScore) {
		this.cashflowScore = cashflowScore;
	}

	public Boolean getAutopayEnrolled() {
		return autopayEnrolled;
	}

	public void setAutopayEnrolled(Boolean autopayEnrolled) {
		this.autopayEnrolled = autopayEnrolled;
	}

	public BigDecimal getAppraisedValue() {
		return appraisedValue;
	}

	public void setAppraisedValue(BigDecimal appraisedValue) {
		this.appraisedValue = appraisedValue;
	}

	public Double getAvmConfidence() {
		return avmConfidence;
	}

	public void setAvmConfidence(Double avmConfidence) {
		this.avmConfidence = avmConfidence;
	}

	public Date getAppraisalDate() {
		return appraisalDate;
	}

	public void setAppraisalDate(Date appraisalDate) {
		this.appraisalDate = appraisalDate;
	}

	public String getUnderwritingStatus() {
		return underwritingStatus;
	}

	public void setUnderwritingStatus(String underwritingStatus) {
		this.underwritingStatus = underwritingStatus;
	}

	public String getUnderwritingNotes() {
		return underwritingNotes;
	}

	public void setUnderwritingNotes(String underwritingNotes) {
		this.underwritingNotes = underwritingNotes;
	}

	public BigDecimal getApprovedCreditLine() {
		return approvedCreditLine;
	}

	public void setApprovedCreditLine(BigDecimal approvedCreditLine) {
		this.approvedCreditLine = approvedCreditLine;
	}

	public BigDecimal getMonthlyPayment() {
		return monthlyPayment;
	}

	public void setMonthlyPayment(BigDecimal monthlyPayment) {
		this.monthlyPayment = monthlyPayment;
	}
}
