package com.insurance.controlers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.DTO.CitizenPlanDTO;
import com.insurance.entity.CitizenPlan;
import com.insurance.service.ReportService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ReportController {
	@Autowired
	ReportService reportService;

	
	@GetMapping("/plans")
	public List<String> getPlans() {

		return reportService.getPlanName();
	}
	
	@GetMapping("/status")
	public List<String> getStatus() {

		return reportService.getStatus();
	}
	
	
	@PostMapping("/search")
	public List<CitizenPlan> getSearch(@RequestBody CitizenPlanDTO citizenPlanDTO) {
		
		return reportService.search(citizenPlanDTO);
	}

}
