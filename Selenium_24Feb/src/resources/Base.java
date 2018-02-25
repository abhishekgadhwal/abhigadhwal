package resources;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Base {

	
	public static WebDriver driver;//global driver declaration//
	
	public WebDriver InitializeDriver() throws IOException 
	{
		
		String browserName = Constants.browser;
		if (browserName.equals("chrome"))
		{
			//chrome-executable code
			System.setProperty("webdriver.chrome.driver","C:\\\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println(browserName);
		}
		else if (browserName.equals("firefox"))
		{
			//
			System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}	
		else if(browserName.equals("IE"))
		{
			//
			System.setProperty("webdriver.ie.driver","C:\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);//Browser takes time to load full 
		return driver;	
	}
	
	public void screenShots(String result) throws IOException, InterruptedException
	{
	    File scr=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

	    File dest= new File("D:\\Eclipse Screenshots\\Screenshots_"+timestamp()+".png");
	    FileUtils.copyFile(scr, dest);
	}

	public String timestamp() 
	{
	    return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}


}
