package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import junit.framework.Assert;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base_class;

public class ValidateTitle extends Base_class{
	public static Logger log = LogManager.getLogger(ValidateTitle.class.getName());
	
	@BeforeTest()
	public void setup() throws IOException
	{
		driver = InitializeDriver();
		log.info("Driver initialization in progress.");
		driver.get(prop.getProperty("URL"));
		log.info("URL entered in the URL bar");
	}
	
	@Test()
	public void VerifyTitle() throws IOException // count of arguments is count of data-columns//
	{
		
		//Create Objects of LandingPage Class and invoke the required methods//
		LandingPage lp = new LandingPage(driver);
		//Comparing the actual value present in the Landing Page using Assertions//
		//mismatch should display error
		Assert.assertEquals("FEATURED COURSES", lp.getTitle().getText());
		log.debug("Text validation in progress");
		log.info("Validation successfully completed.");
	}
	@AfterTest()
	public void CloseBrowser()
	{
		driver.close();
		log.info("Close Browser");
		driver=null; 
	}
	
	
}
