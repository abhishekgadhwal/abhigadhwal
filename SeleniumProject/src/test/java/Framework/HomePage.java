package Framework;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base_class;

public class HomePage extends Base_class{
	public static Logger log = LogManager.getLogger(HomePage.class.getName());
	
	@Test(dataProvider="getData")
	public void LoginPageNavigation(String username,String password, String text) throws IOException // count of arguments is count of data-columns//
	{
		driver = InitializeDriver();
		log.info("Driver initialization in progress.");
		driver.get(prop.getProperty("URL"));
		log.info("URL entered in the URL bar");
		//Create Objects of LandingPage Class and invoke the required methods//
		LandingPage lp = new LandingPage(driver);
		lp.getLogin().click();
		log.debug("login page is opened");
		LoginPage lo = new LoginPage(driver);// passing life to the driver//
		lo.setUserName().sendKeys(username);
		log.info("Username is entered.");
		lo.setPassword().sendKeys(password);
		log.info("Password is entered");
		lo.Submit().click();
		log.debug("User clicks on Login button");
		//System.out.println(text);
		log.info(text);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Rows represent the number of data types required in this test set. // Start with 1. (Array starts with 0,1,...)
		//2nd [] stands for how many values per data-set. (Columns)
		Object[][] data = new Object[2][3]; //Array size is 2 -- (0,1) types of value , //Array size is 3 -- (0,1,2) values
		// 2 set of data(1,2) - Array(0,1) , 3 set of values(1,2,3) - Array-(0,1,2)
		data[0][0] = "abc@def.com";
		data[0][1]="123456";
		data[0][2]="Full-Access";
		
		data[1][0]="xyz@pqr.com";
		data[1][1]="987654";
		data[1][2]="Restricted";
		
		return data;	
	}
	
	@AfterTest()
	public void CloseSessions()
	{
		driver.close();
		log.info("Close Browser");
		driver=null;// to save memory loss//
	}
	
}
