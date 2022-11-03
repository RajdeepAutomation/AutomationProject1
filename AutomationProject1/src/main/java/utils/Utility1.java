package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Calendar;

import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;

import net.bytebuddy.utility.RandomString;

public class Utility1 {
	
	/*	public static void capturescreenshot() {
		System.setProperty("webdriver.chrome.driver","C:\\Users\\RJ\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver ();
		
		driver.get("https://www.facebook.com/");
		

		// Thread.sleep(2000);

		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

	    String demo= RandomString.make();

		
		try {
			File des = new File("C:\\Users\\RJ\\Desktop" + demo + ".jpg");

			FileHandler.copy(src, des);
			
		}

		catch (IOException e) {
			System.out.println(e);
		}
		
	  Calendar cal = Calendar.getInstance();
	  java.util.Date Time = cal.getTime();
	  String timestamp = Time.toString().replace(":", "").replace(" ", "");
	  System.out.println(Time);
	  System.out.println(timestamp);

	   }*/

		public static void getdatafromexcell() {

			for (int i = 0; i <= 3; i++) {
				for (int j = 0; j <= 3; j++) {
	 try {
					FileInputStream file = new FileInputStream("C:\\Users\\RJ\\Desktop\\Excelsheet\\projectreqinfo.xlsx");

					String data = WorkbookFactory.create(file).getSheet("Sheet1").getRow(i).getCell(j).getStringCellValue();

					System.out.print(data + "  ");
					
	    }
	
	 catch (IOException w) {
		System.out.println(w);
		
	      }
				}
				System.out.println();
			}
		}

		public static void main(String[] args)  {

			//capturescreenshot();
			getdatafromexcell();
			
		}

      }
