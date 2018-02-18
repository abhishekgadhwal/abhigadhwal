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

public class ValidateNavBar extends Base_class{
	public static Logger log = LogManager.getLogger(ValidateNavBar.class.getName());
	
	@BeforeTest()
	public void Preconditions() throws IOException
	{
		driver = InitializeDriver();
		log.info("Driver initialization in progress.");
		driver.get(prop.getProperty("URL"));
		log.info("URL entered in the URL bar");
	}
	
	@Test()
	public void VerifyNavBar() throws IOException // count of arguments is count of data-columns//
	{
		
		//Create Objects of LandingPage Class and invoke the required methods//
		LandingPage lp = new LandingPage(driver);
		//Comparing the actual value present in the Landing Page using Assertions//
		//mismatch should display error
		//Assert.assertEquals("FEATURED COURSES", lp.getTitle().getText());
		Assert.assertTrue(lp.getNavbar().isDisplayed());	
		log.info("Navigation Bar is displayed.");
	}
	@AfterTest()
	public void teardown()
	{
		driver.close();
		log.info("Close Browser");
		driver=null;
	}
	
}
