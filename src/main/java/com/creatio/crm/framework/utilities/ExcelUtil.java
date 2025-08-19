package com.creatio.crm.framework.utilities;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {
	
	// Read data from Excel and convert it into collections
	public static List<Map<String,String>> readData(String fileName, String sheetName){
		
		List<Map<String,String>> data = new ArrayList<Map<String,String>>();
		
		try {
			// Read the Excel file
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\TestData\\"+fileName);
			
			// Load the file into Excel class
			XSSFWorkbook wb = new XSSFWorkbook(fis);
			
			// Read the data from specific excel sheet
			XSSFSheet sh = wb.getSheet(sheetName);
			
			// Get the total rows and columns having data
			int totalRows = sh.getPhysicalNumberOfRows();
			int totalColumns = sh.getRow(0).getPhysicalNumberOfCells();
			
			// Use for loops and copy the data (starts with row 2 as row 1 have headers)
			for(int r=1 ; r<totalRows ;r++) {
				
				//Initialize map for each row
				Map<String,String> rowData = new HashMap<String,String>();
				
				for (int c=0; c<totalColumns ; c++) {
					String columnName = sh.getRow(0).getCell(c).getStringCellValue();
					String columnValue = sh.getRow(r).getCell(c).getStringCellValue();
					rowData.put(columnName, columnValue);
				}
				
				//Store each map into main arraylist
				data.add(rowData);
			}			
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		return data;		
	}
	
	// Read data from Excel and convert it into 2D array
	public static String[][] readExcelData(String fileName, String sheetName) {

		String[][] data = null;

		try {
			// Read the Excel file
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\TestData\\" + fileName);

			// Load the file into Excel class
			XSSFWorkbook wb = new XSSFWorkbook(fis);

			// Read the data from specific excel sheet
			XSSFSheet sh = wb.getSheet(sheetName);

			// Get the total rows and columns having data
			int totalRows = sh.getPhysicalNumberOfRows();
			int totalColumns = sh.getRow(0).getPhysicalNumberOfCells();
			
			// Create the array with specific size
			data = new String[totalRows-1][totalColumns];
			
			// Use for loop to store the data
			for(int r=1; r<totalRows; r++) {
				
				for(int c=0; c<totalColumns; c++) {
					
					String cellValue = sh.getRow(r).getCell(c).getStringCellValue();
					data[r-1][c] = cellValue;
					
				}
				
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;		
	}

}
