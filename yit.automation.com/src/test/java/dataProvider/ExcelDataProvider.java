package dataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {

	XSSFWorkbook wb;

	public ExcelDataProvider() {

		File src = new File(System.getProperty("user.dir") + "/TestData/Login.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);

			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {

			System.out.println("ERROR: Unable to load the Excel file" + e.getMessage());

		}

		System.out.println("INFO: Excel File loaded and Ready to use");
		// Above three lines atleast it will load my excel sheet

	}
	// Below method is userprovideing sheetname and row numbr and coulum number
	public String getStringData(String sheetname,int row,int colum)
	{
		
		String data=wb.getSheet(sheetname).getRow(row).getCell(colum).getStringCellValue();
		
		return data;
		
	}
	// Below method user is providing index number and row number . insted of string  here we are using 
	//we are using int indexnumber whenever we take integer number we can take GetsheetAt method 
	public String getStringData(int sheetIndex,int row,int colum)
	{
		
		String data=wb.getSheetAt(sheetIndex).getRow(row).getCell(colum).getStringCellValue();
		
		return data;
		
	}
	
	//Below method used to get integer value from user
	public double getDoubleData(int sheetIndex,int row,int colum)
	{
		
		double data=wb.getSheetAt(sheetIndex).getRow(row).getCell(colum).getNumericCellValue();
		
		
		return data;
		
	}
	//Incase i dont need double i want only int type
	
	//Below method used to get integer value from user
		public int getIntData(int sheetIndex,int row,int colum)
		{
			
			int data=(int)wb.getSheetAt(sheetIndex).getRow(row).getCell(colum).getNumericCellValue();
			
			
			return data;
			
		}

}
