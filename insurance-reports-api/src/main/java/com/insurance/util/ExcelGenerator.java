package com.insurance.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import com.insurance.entity.CitizenPlan;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class ExcelGenerator {

	public boolean excleGenertator(HttpServletResponse response, List<CitizenPlan> plans , File file) throws Exception {

		// create a new work book
		Workbook workbook = new XSSFWorkbook();

		// create a new excele sheet
		Sheet sheet = workbook.createSheet("Insurance Reports");

		// create a row
		Row header = sheet.createRow(0);

		// create cell and add the value
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
			if (null != plane.getBenefitAmount()) {
				row.createCell(4).setCellValue(plane.getBenefitAmount());
			} else {
				row.createCell(4).setCellValue("N/A");
			}
			row.createCell(5).setCellValue(plane.getPlanStartDate() + "");
			row.createCell(6).setCellValue(plane.getPlanEndDate() + "");
			row.createCell(7).setCellValue(plane.getDenialReason());

			index++;
		}

		// This is use to create the file and save in the local server and send to email
		FileOutputStream fos = new  FileOutputStream(file);
		workbook.write(fos);
		fos.close();

		// This is use to create the file and send to the browoser
		ServletOutputStream outputStream = response.getOutputStream();
		workbook.write(outputStream);
		workbook.close();

		
		
		return true;
	}
}
