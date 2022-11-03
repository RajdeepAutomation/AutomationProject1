package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import org.apache.poi.hpsf.Date;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	public static String fetchDataFromExcelsheet(String sheet, int row, int column) throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\RJ\\Desktop\\Excelsheet\\projectreqinfo.xlsx");
		
		String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(column).getStringCellValue();
		
		return data;
		
	}
 public static void capture(WebDriver driver) throws IOException {
	 
	Date date = new Date();
	
	DateFormat d = new SimpleDateFormat("mm-dd-yy & hh-mm-ss");
	
	String df = d.format(date);
	
	File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	File dest = new File("C:\\Users\\RJ\\Desktop\\Screenshots"+ df +".jpg");
	
	FileHandler.copy(src, dest);	 
	 
 }
	
	
}
