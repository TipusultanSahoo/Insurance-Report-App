package com.insurance.DTO;

import java.time.LocalDate;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class CitizenPlanDTO {
	
	String planName;
	String planStatus;
	String gender;
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	LocalDate startDate;
	@DateTimeFormat(pattern = "dd-mm-yyyy")
	LocalDate endDate;
	
	
	public String getPlanName() {
		return planName;
	}
	public void setPlanName(String planName) {
		this.planName = planName;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String status) {
		this.planStatus = status;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	
@Override
public String toString() {
	// TODO Auto-generated method stub
	return planName +" - "+ planStatus +", StartDate" +startDate + ", EndDate"+endDate;
}
}
