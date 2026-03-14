package me.anichakra.poc.pilot.heloc.credit.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class CreditReport implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Long id;
	private Long applicationId;
	private int creditScore;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Tradeline> tradelines;

	private Date pullDate;

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

	public int getCreditScore() {
		return creditScore;
	}

	public void setCreditScore(int creditScore) {
		this.creditScore = creditScore;
	}

	public List<Tradeline> getTradelines() {
		return tradelines;
	}

	public void setTradelines(List<Tradeline> tradelines) {
		this.tradelines = tradelines;
	}

	public Date getPullDate() {
		return pullDate;
	}

	public void setPullDate(Date pullDate) {
		this.pullDate = pullDate;
	}
}
