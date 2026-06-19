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
		
		
		//creating a document
		Document document = new Document(PageSize.A4);
		
		PdfWriter.getInstance(document, response.getOutputStream());
		
		document.open();
		
		//add a paragraph in the document
	    Paragraph p = new Paragraph("Citizen plane Info Report");
	        p.setAlignment(Paragraph.ALIGN_CENTER);
	    document.add(p);
		
	    //creating a table
	    PdfPTable table= new PdfPTable(9);
	    
	        //adding some style to the table - it can skip or modify as per visualisation
	        table.setWidthPercentage(100f);
            table.setWidths(new float[] {1.5f, 4.0f, 1.5f, 2.7f, 2.0f, 2.5f, 4.0f, 4.0f, 4.0f});
            table.setSpacingBefore(10);
            
            
	    //adding table header
	    table.addCell("Id");
	    table.addCell("Citizen Name");
	    table.addCell("Gender");
	    table.addCell("Plan Name");
	    table.addCell("Status");
	    table.addCell("Benefit Amount");
	    table.addCell("Start Date");
	    table.addCell("End Date");
	    table.addCell("Denial Reason");
	    
	    //adding table data rows
	    for(CitizenPlan plan : plans) {
	    	
	    	table.addCell(plan.getCitizenId()+"");
	    	table.addCell(plan.getCitizenName());
	    	table.addCell(plan.getGender());
	    	table.addCell(plan.getPlanName());
	    	table.addCell(plan.getPlanStatus());
	    	table.addCell(plan.getBenefitAmount()+"");
	    	table.addCell(plan.getPlanStartDate()+"");
	    	table.addCell(plan.getPlanEndDate()+"");
	    	table.addCell(plan.getDenialReason());
	    }
	    
	    //table add to the document
	    document.add(table);
	    
	    
	    document.close();
		
		return true;
	}
	
	

	@Override
	public boolean exportExcel(HttpServletResponse response) throws Exception {
		// find all the records in the data base 
		List<CitizenPlan> plans = citizenPlanRepo.findAll();
		
		//create a new work book
		Workbook workbook = new XSSFWorkbook();
		
		//create a new excele sheet
		Sheet sheet = workbook.createSheet("Insurance Reports");
        
		//create a row
		Row header = sheet.createRow(0);
        
		//create cell and add the value
		header.createCell(0).setCellValue("Citizen Name");
		header.createCell(1).setCellValue("Gender");
		header.createCell(2).setCellValue("Plan Name");
		header.createCell(3).setCellValue("Status");
		header.createCell(4).setCellValue("Benefit Amount");
		header.createCell(5).setCellValue("Start Date");
		header.createCell(6).setCellValue("End Date");
		header.createCell(7).setCellValue("Denial Reason");

		int index = 1;

		for (CitizenPlan plane : plans) {

			Row row = sheet.createRow(index);

			row.createCell(0).setCellValue(plane.getCitizenName());
			row.createCell(1).setCellValue(plane.getGender());
			row.createCell(2).setCellValue(plane.getPlanName());
			row.createCell(3).setCellValue(plane.getPlanStatus());
			if(null != plane.getBenefitAmount()) {
				row.createCell(4).setCellValue(plane.getBenefitAmount());
			}
			else {
				row.createCell(4).setCellValue("N/A");
			}
			row.createCell(5).setCellValue(plane.getPlanStartDate() + "");
			row.createCell(6).setCellValue(plane.getPlanEndDate() + "");
			row.createCell(7).setCellValue(plane.getDenialReason());

			index++;
		}
		
//		FileOutputStream fos = new  FileOutputStream(new File("plneReports.xls"));
//		
//		workbook.write(fos);
//		workbook.close();
		
		ServletOutputStream outputStream = response.getOutputStream();
		
		workbook.write(outputStream);
		workbook.close();
		
		return true;
	}

	

}
