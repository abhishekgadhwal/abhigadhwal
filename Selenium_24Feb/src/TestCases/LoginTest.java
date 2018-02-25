package TestCases;

import java.io.FileNotFoundException;
import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ObjectRepository.Objects_Definition_Login;
import resources.Base;
import resources.Constants;

public class LoginTest extends Base {
	
	public static WebDriver driver;
	
	@Test(dataProvider = "getData")
	public void LoginPageNavigation(String username,String password) throws IOException // count of arguments is count of data-columns//
	{
		driver = InitializeDriver();
		driver.get(Constants.URL);
		System.out.println("URL entered successfully");
		Objects_Definition_Login od = new Objects_Definition_Login(driver);
		od.ClickLoginButton().click();
		od.setUserName().sendKeys(username);
		od.setPassword().sendKeys(password);
		od.Submit().click();

	}

	@DataProvider()
	public Object[][] getData()
	{

		Object[][] data = new Object[2][2];
		
		data[0][0] = Constants.Username1;
		data[0][1]= Constants.Password1;
		data[1][0]= Constants.Username2;
		data[1][1]=Constants.Password2;		
		return data;
	}


	@AfterTest()
	public void Teardown1()
	{
		driver.close();
		driver=null;
		
	}
}