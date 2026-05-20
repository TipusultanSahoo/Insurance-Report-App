package com.insurance.service;

import java.util.List;

import com.insurance.DTO.CitizenPlanDTO;
import com.insurance.entity.CitizenPlan;

public interface ReportService {

	public List<String> getPlanName();
	
	public List<String> getStatus();
	
	public List<CitizenPlan> search(CitizenPlanDTO c);
	
	public boolean exportPDF();
	
	public boolean exportExcel();
}
