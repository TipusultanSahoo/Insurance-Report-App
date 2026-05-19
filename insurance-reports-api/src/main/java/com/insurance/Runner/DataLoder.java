package com.insurance.Runner;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.insurance.entity.CitizenPlan;
import com.insurance.entity.PlanMaster;
import com.insurance.repo.CitizenPlanRepo;
import com.insurance.repo.PlanMasterRepo;

@Component
public class DataLoder implements ApplicationRunner {

	@Autowired
	private PlanMasterRepo planMasterRepo;

	@Autowired
	private CitizenPlanRepo citizenPlanRepo; 

	@Override
	public void run(ApplicationArguments args) throws Exception {

		// Clear existing data to prevent duplicate inserts on restarts (Optional)
		planMasterRepo.deleteAll();
		citizenPlanRepo.deleteAll();

		// =================================================================
		// 1. INSERTING DUMMY DATA FOR PLAN MASTER (6 Plans)
		// =================================================================
		PlanMaster p1 = new PlanMaster();
		p1.setPlanName("SNAP");
		PlanMaster p2 = new PlanMaster();
		p2.setPlanName("CCAP");
		PlanMaster p3 = new PlanMaster();
		p3.setPlanName("Medicaid");
		PlanMaster p4 = new PlanMaster();
		p4.setPlanName("Medicare");
		PlanMaster p5 = new PlanMaster();
		p5.setPlanName("NJ Well");
		PlanMaster p6 = new PlanMaster();
		p6.setPlanName("Employment");

		planMasterRepo.saveAll(Arrays.asList(p1, p2, p3, p4, p5, p6));

		// =================================================================
		// 2. INSERTING DUMMY DATA FOR CITIZEN PLAN (18 Records)
		// =================================================================

		// --- SNAP Plan Records ---

		CitizenPlan c1 = new CitizenPlan();
		c1.setCitizenName("John Doe");
		c1.setGender("Male");
		c1.setEmail("john@gmail.com");
		c1.setMobileNumber("9876543210");
		c1.setPlanName("SNAP");
		c1.setPlanStatus("Approved");
		c1.setBenefitAmount(5000.0);
		c1.setPlanStartDate(LocalDate.now().minusMonths(3));
		c1.setPlanEndDate(LocalDate.now().plusMonths(9));

		CitizenPlan c2 = new CitizenPlan();
		c2.setCitizenName("Smith Smith");
		c2.setGender("Male");
		c2.setEmail("smith@gmail.com");
		c2.setMobileNumber("9876543211");
		c2.setPlanName("SNAP");
		c2.setPlanStatus("Denied");
		c2.setDenialReason("High Income");

		CitizenPlan c3 = new CitizenPlan();
		c3.setCitizenName("Emily Davis");
		c3.setGender("Female");
		c3.setEmail("emily@gmail.com");
		c3.setMobileNumber("9876543212");
		c3.setPlanName("SNAP");
		c3.setPlanStatus("Terminated");
		c3.setBenefitAmount(4500.0);
		c3.setPlanStartDate(LocalDate.now().minusMonths(6));
		c3.setPlanEndDate(LocalDate.now().minusMonths(1));
		c3.setDenialReason("Employed");

		// --- CCAP Plan Records ---

		CitizenPlan c4 = new CitizenPlan();
		c4.setCitizenName("David Warner");
		c4.setGender("Male");
		c4.setEmail("david@gmail.com");
		c4.setMobileNumber("8765432109");
		c4.setPlanName("CCAP");
		c4.setPlanStatus("Approved");
		c4.setBenefitAmount(6000.0);
		c4.setPlanStartDate(LocalDate.now().minusMonths(2));
		c4.setPlanEndDate(LocalDate.now().plusMonths(10));

		CitizenPlan c5 = new CitizenPlan();
		c5.setCitizenName("Jessica Taylor");
		c5.setGender("Female");
		c5.setEmail("jessica@gmail.com");
		c5.setMobileNumber("8765432108");
		c5.setPlanName("CCAP");
		c5.setPlanStatus("Denied");
		c5.setDenialReason("Property Ownership");

		CitizenPlan c6 = new CitizenPlan();
		c6.setCitizenName("Robert Downey");
		c6.setGender("Male");
		c6.setEmail("robert@gmail.com");
		c6.setMobileNumber("8765432107");
		c6.setPlanName("CCAP");
		c6.setPlanStatus("Terminated");
		c6.setBenefitAmount(5500.0);
		c6.setPlanStartDate(LocalDate.now().minusMonths(8));
		c6.setPlanEndDate(LocalDate.now().minusMonths(2));
		c6.setDenialReason("Government Job");

		// --- Medicaid Plan Records ---
		
		CitizenPlan c7 = new CitizenPlan();
		c7.setCitizenName("Sarah Connor");
		c7.setGender("Female");
		c7.setEmail("sarah@gmail.com");
		c7.setMobileNumber("7654321098");
		c7.setPlanName("Medicaid");
		c7.setPlanStatus("Approved");
		c7.setBenefitAmount(8000.0);
		c7.setPlanStartDate(LocalDate.now().minusMonths(1));
		c7.setPlanEndDate(LocalDate.now().plusMonths(11));

		CitizenPlan c8 = new CitizenPlan();
		c8.setCitizenName("Michael Clark");
		c8.setGender("Male");
		c8.setEmail("michael@gmail.com");
		c8.setMobileNumber("7654321097");
		c8.setPlanName("Medicaid");
		c8.setPlanStatus("Denied");
		c8.setDenialReason("Age Criteria");

		// --- Medicare Plan Records ---
		
		CitizenPlan c9 = new CitizenPlan();
		c9.setCitizenName("James Bond");
		c9.setGender("Male");
		c9.setEmail("james@gmail.com");
		c9.setMobileNumber("6543210987");
		c9.setPlanName("Medicare");
		c9.setPlanStatus("Approved");
		c9.setBenefitAmount(9000.0);
		c9.setPlanStartDate(LocalDate.now().minusMonths(4));
		c9.setPlanEndDate(LocalDate.now().plusMonths(8));

		CitizenPlan c10 = new CitizenPlan();
		c10.setCitizenName("Mary Kom");
		c10.setGender("Female");
		c10.setEmail("mary@gmail.com");
		c10.setMobileNumber("6543210986");
		c10.setPlanName("Medicare");
		c10.setPlanStatus("Denied");
		c10.setDenialReason("Medical Fitness Status");

		CitizenPlan c11 = new CitizenPlan();
		c11.setCitizenName("Paul Walker");
		c11.setGender("Male");
		c11.setEmail("paul@gmail.com");
		c11.setMobileNumber("6543210985");
		c11.setPlanName("Medicare");
		c11.setPlanStatus("Terminated");
		c11.setBenefitAmount(9000.0);
		c11.setPlanStartDate(LocalDate.now().minusMonths(12));
		c11.setPlanEndDate(LocalDate.now().minusMonths(6));
		c11.setDenialReason("Expired");

		// --- NJ Well Plan Records ---
		
		CitizenPlan c12 = new CitizenPlan();
		c12.setCitizenName("Bruce Wayne");
		c12.setGender("Male");
		c12.setEmail("bruce@gmail.com");
		c12.setMobileNumber("5432109876");
		c12.setPlanName("NJ Well");
		c12.setPlanStatus("Approved");
		c12.setBenefitAmount(3000.0);
		c12.setPlanStartDate(LocalDate.now().minusMonths(5));
		c12.setPlanEndDate(LocalDate.now().plusMonths(7));

		CitizenPlan c13 = new CitizenPlan();
		c13.setCitizenName("Diana Prince");
		c13.setGender("Female");
		c13.setEmail("diana@gmail.com");
		c13.setMobileNumber("5432109875");
		c13.setPlanName("NJ Well");
		c13.setPlanStatus("Denied");
		c13.setDenialReason("Tax Evader");

		// --- Employment Plan Records ---
		
		CitizenPlan c14 = new CitizenPlan();
		c14.setCitizenName("Peter Parker");
		c14.setGender("Male");
		c14.setEmail("peter@gmail.com");
		c14.setMobileNumber("4321098765");
		c14.setPlanName("Employment");
		c14.setPlanStatus("Approved");
		c14.setBenefitAmount(12000.0);
		c14.setPlanStartDate(LocalDate.now().minusMonths(2));
		c14.setPlanEndDate(LocalDate.now().plusMonths(10));

		CitizenPlan c15 = new CitizenPlan();
		c15.setCitizenName("Tony Stark");
		c15.setGender("Male");
		c15.setEmail("tony@gmail.com");
		c15.setMobileNumber("4321098764");
		c15.setPlanName("Employment");
		c15.setPlanStatus("Denied");
		c15.setDenialReason("High Asset Valuation");

		CitizenPlan c16 = new CitizenPlan();
		c16.setCitizenName("Natasha Romanoff");
		c16.setGender("Female");
		c16.setEmail("natasha@gmail.com");
		c16.setMobileNumber("4321098763");
		c16.setPlanName("Employment");
		c16.setPlanStatus("Terminated");
		c16.setBenefitAmount(11000.0);
		c16.setPlanStartDate(LocalDate.now().minusMonths(6));
		c16.setPlanEndDate(LocalDate.now().minusMonths(2));
		c16.setDenialReason("Resigned");

		CitizenPlan c17 = new CitizenPlan();
		c17.setCitizenName("Steve Rogers");
		c17.setGender("Male");
		c17.setEmail("steve@gmail.com");
		c17.setMobileNumber("4321098762");
		c17.setPlanName("Employment");
		c17.setPlanStatus("Approved");
		c17.setBenefitAmount(15000.0);
		c17.setPlanStartDate(LocalDate.now().minusMonths(1));
		c17.setPlanEndDate(LocalDate.now().plusMonths(11));

		CitizenPlan c18 = new CitizenPlan();
		c18.setCitizenName("Wanda Maximoff");
		c18.setGender("Female");
		c18.setEmail("wanda@gmail.com");
		c18.setMobileNumber("4321098761");
		c18.setPlanName("Employment");
		c18.setPlanStatus("Approved");
		c18.setBenefitAmount(14000.0);
		c18.setPlanStartDate(LocalDate.now().minusDays(15));
		c18.setPlanEndDate(LocalDate.now().plusMonths(6));

		// Batch save all citizens
		List<CitizenPlan> citizenList = Arrays.asList(c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15,
				c16, c17, c18);
		citizenPlanRepo.saveAll(citizenList);

		System.out.println(">> Dummy Data Loaded successfully!");
	}
}