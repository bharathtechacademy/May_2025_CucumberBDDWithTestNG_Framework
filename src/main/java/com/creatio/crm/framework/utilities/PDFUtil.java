package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFUtil {

	public static String getPDFText(String fileName) {
		String text = "";

		try {
			// Read the Excel file
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Files\\" + fileName);
			
			//Load PDF file into PDDocument class to read PDF
			PDDocument document = PDDocument.load(fis);
			
			// Copy/ Extract text from PDF file
			PDFTextStripper pdf = new PDFTextStripper();
			text = pdf.getText(document);		
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return text;
	}
	
	
	public static String getPDFText(String fileName, int startPage, int endPage) {
		String text = "";

		try {
			// Read the Excel file
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\Files\\" + fileName);
			
			//Load PDF file into PDDocument class to read PDF
			PDDocument document = PDDocument.load(fis);
			
			// Copy/ Extract text from PDF file
			PDFTextStripper pdf = new PDFTextStripper();
			
			pdf.setStartPage(startPage);
			pdf.setEndPage(endPage);
			
			text = pdf.getText(document);					
			
		} catch (Exception e) {
			e.printStackTrace();
		}

		return text;
	}

}
