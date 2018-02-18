package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {


	public WebDriver driver;
	
	//By SignIn = By.xpath("//span[text()='Login']");
	By Username = By.xpath("//input[@id='user_email']");
	By Password = By.xpath("//input[@id='user_password']");
	By Submit = By.xpath("//input[@value='Log In']");
	
	public LoginPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;// passing life to the local driver so that it can have the same properties of the Global Driver variable used for Test-Ex//
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
