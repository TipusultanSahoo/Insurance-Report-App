package com.insurance.service;


import java.util.List;
import com.insurance.DTO.CitizenPlanDTO;
import com.insurance.entity.CitizenPlan;

import jakarta.servlet.http.HttpServletResponse;

public interface ReportService {

	public List<String> getPlanName();
	
	public List<String> getStatus();
	
	public List<CitizenPlan> search(CitizenPlanDTO c);
	
	public boolean exportPDF(HttpServletResponse response) throws Exception;
	
	public boolean exportExcel(HttpServletResponse response) throws Exception;
}
