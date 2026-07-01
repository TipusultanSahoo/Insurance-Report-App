package com.insurance.util;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.springframework.stereotype.Component;

import com.insurance.entity.CitizenPlan;
import com.lowagie.text.Document;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class PdfGenerator {

	public boolean pdfGenertator(HttpServletResponse response, List<CitizenPlan> plans , File file) throws Exception {

		// creating a document
		Document document = new Document(PageSize.A4);
        
		//send the file to browser
		PdfWriter.getInstance(document, response.getOutputStream());
		//save the file locale and use to send to the mail 
		PdfWriter.getInstance(document, new FileOutputStream(file));

		document.open();

		// add a paragraph in the document
		Paragraph p = new Paragraph("Citizen plane Info Report");
		p.setAlignment(Paragraph.ALIGN_CENTER);
		document.add(p);

		// creating a table
		PdfPTable table = new PdfPTable(9);

		// adding some style to the table - it can skip or modify as per visualisation
		table.setWidthPercentage(100f);
		table.setWidths(new float[] { 1.5f, 4.0f, 1.5f, 2.7f, 2.0f, 2.5f, 4.0f, 4.0f, 4.0f });
		table.setSpacingBefore(10);

		// adding table header
		table.addCell("Id");
		table.addCell("Citizen Name");
		table.addCell("Gender");
		table.addCell("Plan Name");
		table.addCell("Status");
		table.addCell("Benefit Amount");
		table.addCell("Start Date");
		table.addCell("End Date");
		table.addCell("Denial Reason");

		// adding table data rows
		for (CitizenPlan plan : plans) {

			table.addCell(plan.getCitizenId() + "");
			table.addCell(plan.getCitizenName());
			table.addCell(plan.getGender());
			table.addCell(plan.getPlanName());
			table.addCell(plan.getPlanStatus());
			table.addCell(plan.getBenefitAmount() + "");
			table.addCell(plan.getPlanStartDate() + "");
			table.addCell(plan.getPlanEndDate() + "");
			table.addCell(plan.getDenialReason());
		}

		// table add to the document
		document.add(table);

		document.close();

		return true;
	}

}
