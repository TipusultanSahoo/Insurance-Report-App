package com.insurance.util;

import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.insurance.entity.CitizenPlan;

public class ExcelGenerator {

	public static void excleGenertator(List<CitizenPlan> plans) {

		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Insurance Reports");

		Row header = sheet.createRow(0);

		header.createCell(0).setCellValue("Citizen Name");
		header.createCell(1).setCellValue("Gender");
		header.createCell(2).setCellValue("Plan Name");
		header.createCell(3).setCellValue("Status");
		header.createCell(4).setCellValue("Benefit Amount");
		header.createCell(5).setCellValue("Start Date");
		header.createCell(6).setCellValue("End Date");
		header.createCell(7).setCellValue("Denial Reason");

		int index = 1;

		for (CitizenPlan cp : plans) {

			Row row = sheet.createRow(index);

			row.createCell(0).setCellValue(cp.getCitizenName());
			row.createCell(1).setCellValue(cp.getGender());
			row.createCell(2).setCellValue(cp.getPlanName());
			row.createCell(3).setCellValue(cp.getPlanStatus());
			row.createCell(4).setCellValue(cp.getBenefitAmount());
			row.createCell(5).setCellValue(cp.getPlanStartDate() + "");
			row.createCell(6).setCellValue(cp.getPlanEndDate() + "");
			row.createCell(7).setCellValue(cp.getDenialReason());

			index++;
		}

	}
}
