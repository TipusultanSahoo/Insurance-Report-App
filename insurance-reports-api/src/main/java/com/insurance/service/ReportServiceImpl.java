package com.insurance.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.insurance.DTO.CitizenPlanDTO;
import com.insurance.InsuranceReportsApiApplication;
import com.insurance.entity.CitizenPlan;
import com.insurance.repo.CitizenPlanRepo;
import com.insurance.repo.PlanMasterRepo;

@Service
public class ReportServiceImpl implements ReportService {

    private final InsuranceReportsApiApplication insuranceReportsApiApplication;
	
	@Autowired
	CitizenPlanRepo citizenPlanRepo;
	@Autowired
	PlanMasterRepo planMasterRepo;
	private List<CitizenPlan> all;
	private List<CitizenPlan> collect;


    ReportServiceImpl(InsuranceReportsApiApplication insuranceReportsApiApplication) {
        this.insuranceReportsApiApplication = insuranceReportsApiApplication;
    }
	

	@Override
	public List<String> getPlanName() {
		
		return planMasterRepo.getPlanNames();
		
//		return planMasterRepo.findAll()
//				.stream()
//			     .map(x->x.getPlanName())
//				  .collect(Collectors.toList());
		
	}

	@Override
	public List<String> getStatus() {
		
		return citizenPlanRepo.getPlanStatus();
		
//		return List.of(
//				"Approved",
//                "Denied"
//				);
	}

//    @Override
//    public List<CitizenPlan> search(
//            CitizenPlanDTO c) {
//
//        // GET ALL DATA
//        List<CitizenPlan> allData =
//                citizenPlanRepo.findAll();
//
//        // FILTER DATA
//        List<CitizenPlan> filteredData =
//
//                allData.stream()
//
//                        .filter(x -> {
//
//                            boolean marking = true;
//
//                            // =====================
//                            // PLAN NAME
//                            // =====================
//                            if (c.getPlanName() != null
//                                    && !c.getPlanName().isEmpty()) {
//
//                                if (!c.getPlanName()
//                                        .equals(x.getPlanName())) {
//
//                                    marking = false;
//                                }
//                            }
//
//                            // =====================
//                            // PLAN STATUS
//                            // =====================
//                            if (c.getPlanStatus() != null
//                                    && !c.getPlanStatus().isEmpty()) {
//
//                                if (!c.getPlanStatus()
//                                        .equals(x.getPlanStatus())) {
//
//                                    marking = false;
//                                }
//                            }
//
//                            // =====================
//                            // GENDER
//                            // =====================
//                            if (c.getGender() != null
//                                    && !c.getGender().isEmpty()) {
//
//                                if (!c.getGender()
//                                        .equals(x.getGender())) {
//
//                                    marking = false;
//                                }
//                            }
//
//                            // =====================
//                            // START DATE
//                            // =====================
//                            if (c.getStartDate() != null) {
//
//                                if (!c.getStartDate()
//                                        .equals(
//                                                x.getPlanStartDate())) {
//
//                                    marking = false;
//                                }
//                            }
//
//                            // =====================
//                            // END DATE
//                            // =====================
//                            if (c.getEndDate() != null) {
//
//                                if (!c.getEndDate()
//                                        .equals(
//                                                x.getPlanEndDate())) {
//
//                                    marking = false;
//                                }
//                            }
//
//                            return marking;
//                        })
//
//                        .collect(Collectors.toList());
//
//        System.out.println(filteredData);
//
//        return filteredData;
//    }
	
	@Override
    public List<CitizenPlan> search(CitizenPlanDTO c) {
		
		CitizenPlan cit = new CitizenPlan();
		cit.setPlanName(c.getPlanName());
		cit.setPlanStatus(c.getPlanStatus());
		cit.setGender(c.getGender());
		cit.setPlanStartDate(c.getStartDate());
		cit.setPlanEndDate(c.getEndDate());
		
		
		System.out.println("Plan Name  : " + c.getPlanName());
		System.out.println("Plan Status: " + c.getPlanStatus());
		System.out.println("Gender     : " + c.getGender());
		System.out.println("Start Date : " + c.getStartDate());
		System.out.println("End Date   : " + c.getEndDate());
		
		Example<CitizenPlan> ex = Example.of(cit);
		
		System.out.println(citizenPlanRepo.findAll(ex));
		return citizenPlanRepo.findAll(ex);
	}
	@Override
	public boolean exportPDF() {
		
		return false;
	}

	@Override
	public boolean exportExcel() {
		
		return false;
	}

	

}
