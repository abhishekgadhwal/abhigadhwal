package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Locale;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.openqa.selenium.By;

public class TC_02 {
	  	public static XSSFWorkbook wb;// global definition for re-usability//
		public static XSSFSheet sheet;
		public static XSSFRow row;
		public static XSSFCell cell;
		public static FileInputStream Files;
		public static WebDriver driver = null;

	 
	@Test ()
	  public void TestCase2() throws IOException  {
		
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.get("http://newtours.demoaut.com/mercurywelcome.php");
		 driver.findElement(By.name("userName")).sendKeys("mercury");
		 driver.findElement(By.name("password")).sendKeys("mercury");
		 driver.findElement(By.name("login")).click();
		
	
		 
		Files = new FileInputStream("D:\\Sample.xlsx");
		wb = new XSSFWorkbook(Files);
		sheet = wb.getSheet("Sheet1");
		int rowcount=sheet.getLastRowNum();
		for(int i=0;i<rowcount;i++) 
		{
			int data0 = (int)wb.getSheet("Sheet1").getRow(i).getCell(0).getNumericCellValue();
		    String data1 = String.valueOf(sheet.getRow(i).getCell(1).getStringCellValue());
		    int data2 = (int)wb.getSheet("Sheet1").getRow(i).getCell(2).getNumericCellValue();
		    int data3 = (int)wb.getSheet("Sheet1").getRow(i).getCell(3).getNumericCellValue();
		    String data4 = String.valueOf(sheet.getRow(i).getCell(4).getStringCellValue());
		    int data5 = (int)wb.getSheet("Sheet1").getRow(i).getCell(5).getNumericCellValue();
		    int data6 = (int)wb.getSheet("Sheet1").getRow(i).getCell(6).getNumericCellValue();
		   

			driver.findElement((By.xpath("//input[@value='roundtrip']"))).click();
			new Select(driver.findElement(By.xpath("//select[@name='passCount']"))).selectByVisibleText(Integer.toString(data0));
			new Select(driver.findElement(By.xpath("//select[@name='fromPort']"))).selectByValue(data1);
			new Select(driver.findElement(By.xpath("//select[@name='fromMonth']"))).selectByValue(Integer.toString(data2));
			new Select(driver.findElement(By.xpath("//select[@name='fromDay']"))).selectByVisibleText(Integer.toString(data3));
			new Select(driver.findElement(By.xpath("//select[@name='toPort']"))).selectByValue(data4);
			new Select(driver.findElement(By.xpath("//select[@name='toMonth']"))).selectByValue(Integer.toString(data5));
			new Select(driver.findElement(By.xpath("//select[@name='toDay']"))).selectByVisibleText(Integer.toString(data6));
			
			driver.findElement(By.xpath("//input[@value='Business']")).click();

		
		}
	}
	    
}	




		
		
	   			
	
	  
	  
	    



