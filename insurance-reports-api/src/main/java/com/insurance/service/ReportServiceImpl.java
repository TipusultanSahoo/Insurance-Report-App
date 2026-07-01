package com.insurance.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.insurance.DTO.CitizenPlanDTO;
import com.insurance.InsuranceReportsApiApplication;
import com.insurance.entity.CitizenPlan;
import com.insurance.repo.CitizenPlanRepo;
import com.insurance.repo.PlanMasterRepo;
import com.insurance.util.EmailUtils;
import com.insurance.util.ExcelGenerator;
import com.insurance.util.PdfGenerator;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletResponse;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private CitizenPlanRepo citizenPlanRepo;
	@Autowired
	private PlanMasterRepo planMasterRepo;
	@Autowired
	private ExcelGenerator excelGenerator;
	@Autowired
	private PdfGenerator pdfGenerator;
	@Autowired
    private EmailUtils emailUtils;
	
	

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
		
	}

	
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
	public boolean exportPDF(HttpServletResponse response) throws Exception {
		
		//find all the records
		List<CitizenPlan> plans = citizenPlanRepo.findAll();
		File file= new File("Plans.pdf");
		
		pdfGenerator.pdfGenertator(response, plans,file);
		
		//send mail
		
		String email="sahoogrx03@gmail.com";
		String subject="Test mail";
		String body="<h1> Hello , This is a test PDF mail , body</h1>";
		
		
		emailUtils.sendMail(email, subject, body ,file);
		
		file.delete();
		
		return true;
		
	}
	
	

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		// find all the records in the data base 
		List<CitizenPlan> plans = citizenPlanRepo.findAll();
		
		File file= new File("Plans.xls");
		
		excelGenerator.excleGenertator(response, plans , file);
		
		//send mail
		
		String emailTo="sahoogrx03@gmail.com";
		String subject="Test mail";
		String body="<h1> Hello , This is a test Excel mail , body</h1>";
		
		
		emailUtils.sendMail(emailTo, subject, body , file);
		
		file.delete();
		
		return true;
		
		
	}

	

}
