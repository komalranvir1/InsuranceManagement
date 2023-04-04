package com.insurence.management.entites;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
public class InsurancePolicy {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer policyNo;
	private String policyType;
	private Long coverageAmt;
	private Long premium;
	private Date startDate;
	private Date endDate;
	
	@OneToOne
	@JoinColumn(name = "client_id", referencedColumnName = "id")
	private Client client;

	public InsurancePolicy(Long id, Integer policyNo, String policyType, Long coverageAmt, Long premium, Date startDate,
			Date endDate, Client client) {
		super();
		this.id = id;
		this.policyNo = policyNo;
		this.policyType = policyType;
		this.coverageAmt = coverageAmt;
		this.premium = premium;
		this.startDate = startDate;
		this.endDate = endDate;
		this.client = client;
	}
	
	public InsurancePolicy() {
		// TODO Auto-generated constructor stub
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getPolicyNo() {
		return policyNo;
	}

	public void setPolicyNo(Integer policyNo) {
		this.policyNo = policyNo;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public Long getCoverageAmt() {
		return coverageAmt;
	}

	public void setCoverageAmt(Long coverageAmt) {
		this.coverageAmt = coverageAmt;
	}

	public Long getPremium() {
		return premium;
	}

	public void setPremium(Long premium) {
		this.premium = premium;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
