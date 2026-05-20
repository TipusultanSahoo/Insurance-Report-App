package com.insurance.DTO;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenPlanDTO {
	
	String planName;
	String status;
	String gender;
	LocalDate startDate;
	LocalDate endDate;
	

}
