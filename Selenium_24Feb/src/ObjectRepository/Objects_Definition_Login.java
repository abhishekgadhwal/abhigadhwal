package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Objects_Definition_Login {

	public  WebDriver driver;
	
	public Objects_Definition_Login (WebDriver driver)
	{
		this.driver=driver;	
	}
	
	//Define Locators for the Framework
	By SignIn = By.xpath("//span[text()='Login']");
	By Username = By.xpath("//input[@id='user_email']");
	By Password = By.xpath("//input[@id='user_password']");
	By Submit = By.xpath("//input[@value='Log In']");

	public WebElement ClickLoginButton()
	{
		//return driver.findElement(SignIn);
		return driver.findElement(SignIn);		
	}

	
	public WebElement setUserName()
	{
		//return driver.findElement(SignIn);
		return driver.findElement(Username);		
	}
	
	public WebElement setPassword()
	{
		return driver.findElement(Password);
	}
	public WebElement Submit()
	{
		return driver.findElement(Submit);
	}
}

	

