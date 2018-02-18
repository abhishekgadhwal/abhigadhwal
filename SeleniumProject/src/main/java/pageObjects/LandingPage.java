package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {


	public WebDriver driver;
	
	By SignIn = By.xpath("//span[text()='Login']");
	By Title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	By NavBar = By.xpath("//ul[@class='nav navbar-nav navbar-right']");
	
	public LandingPage(WebDriver driver) 
	{
		// TODO Auto-generated constructor stub
		this.driver=driver;
	}

	public WebElement getLogin()
	{
		return driver.findElement(SignIn);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(Title);
	}

	public WebElement getNavbar()
	{
		return driver.findElement(NavBar);
	}
}
