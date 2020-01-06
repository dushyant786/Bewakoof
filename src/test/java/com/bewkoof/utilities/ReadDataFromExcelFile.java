package com.bewkoof.utilities;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * @author Dushyant
 *
 */

public class ReadDataFromExcelFile {
	
	public XSSFWorkbook wb;
	
	public XSSFSheet sheet;
	
	public ReadDataFromExcelFile(String filePath) 
	{
	  try {
			File src = new File(filePath);
			
			FileInputStream fis = new FileInputStream(src);
			
			wb = new XSSFWorkbook(fis);
		  } 
	   catch (Exception e) 
	      {
			System.out.println(e);
		  }
	  }
	
	public String getData(int sheetnum,int row,int col)
	{
		DataFormatter df = new DataFormatter();
		
		sheet = wb.getSheetAt(sheetnum);
		
		Cell cell = sheet.getRow(row).getCell(col);
				
			//	cell.getStringCellValue();
		
		String data = df.formatCellValue(cell);
		
		try 
		{
			wb.close();
		} 
		catch (Exception e)
		{
			System.out.println(e);
		}
		
		return data;
	}
	
	public int getColumnCount(int sheetnum)
	{
		sheet = wb.getSheetAt(sheetnum);
		
		XSSFRow r = sheet.getRow(1);
		
		int ColCount = r.getLastCellNum();
		
		System.out.println("ColumnCount is "+ColCount);
		
		try
		{
			wb.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return ColCount;
	  }
		
	
	public int getRowCount(int sheetnum)
	{
		sheet = wb.getSheetAt(sheetnum);
		
		int rowCount = sheet.getLastRowNum();
		
		System.out.println("RowCount is "+rowCount);
		
		try
		{
			wb.close();
		} 
		catch (Exception e) 
		{
			System.out.println(e);
		}
		
		return rowCount;
	  }
}
