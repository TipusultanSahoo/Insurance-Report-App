package com.insurance.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "citizen_plan")
public class CitizenPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long citizenId;

    private String citizenName;

    private String gender;

    private String email;

    private String mobileNumber;

    private String planName;

    private String planStatus;

  
	private Double benefitAmount;

    private LocalDate planStartDate;

    private LocalDate planEndDate;

    private String denialReason;
    
    
    public Long getCitizenId() {
  		return citizenId;
  	}

  	public void setCitizenId(Long citizenId) {
  		this.citizenId = citizenId;
  	}

  	public String getCitizenName() {
  		return citizenName;
  	}

  	public void setCitizenName(String citizenName) {
  		this.citizenName = citizenName;
  	}

  	public String getGender() {
  		return gender;
  	}

  	public void setGender(String gender) {
  		this.gender = gender;
  	}

  	public String getEmail() {
  		return email;
  	}

  	public void setEmail(String email) {
  		this.email = email;
  	}

  	public String getMobileNumber() {
  		return mobileNumber;
  	}

  	public void setMobileNumber(String mobileNumber) {
  		this.mobileNumber = mobileNumber;
  	}

  	public String getPlanName() {
  		return planName;
  	}

  	public void setPlanName(String planName) {
  		this.planName = planName;
  	}

  	public String getPlanStatus() {
  		return planStatus;
  	}

  	public void setPlanStatus(String planStatus) {
  		this.planStatus = planStatus;
  	}

  	public Double getBenefitAmount() {
  		return benefitAmount;
  	}

  	public void setBenefitAmount(Double benefitAmount) {
  		this.benefitAmount = benefitAmount;
  	}

  	public LocalDate getPlanStartDate() {
  		return planStartDate;
  	}

  	public void setPlanStartDate(LocalDate planStartDate) {
  		this.planStartDate = planStartDate;
  	}

  	public LocalDate getPlanEndDate() {
  		return planEndDate;
  	}

  	public void setPlanEndDate(LocalDate planEndDate) {
  		this.planEndDate = planEndDate;
  	}

  	public String getDenialReason() {
  		return denialReason;
  	}

  	public void setDenialReason(String denialReason) {
  		this.denialReason = denialReason;
  	}

}