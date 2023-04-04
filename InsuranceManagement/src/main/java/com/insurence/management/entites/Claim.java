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
//@NoArgsConstructor@ToString
public class Claim {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer claimNo;
	private String discription;
	private Date claimDate;
	private String claimStatus;
	
	@OneToOne
	@JoinColumn(name = "policy_id",referencedColumnName = "id")
	private InsurancePolicy insurancePolicy;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getClaimNo() {
		return claimNo;
	}

	public void setClaimNo(Integer claimNo) {
		this.claimNo = claimNo;
	}

	public String getDiscription() {
		return discription;
	}

	public void setDiscription(String discription) {
		this.discription = discription;
	}

	public Date getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(Date claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public InsurancePolicy getInsurancePolicy() {
		return insurancePolicy;
	}

	public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}

	public Claim(Long id, Integer claimNo, String discription, Date claimDate, String claimStatus,
			InsurancePolicy insurancePolicy) {
		super();
		this.id = id;
		this.claimNo = claimNo;
		this.discription = discription;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.insurancePolicy = insurancePolicy;
	}

	public Claim() {
		// TODO Auto-generated constructor stub
	}
	
}
