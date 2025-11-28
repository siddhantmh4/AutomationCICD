package seleniumFrameworkDesign.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageobjects.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents{
	
	WebDriver driver;
	public LandingPage(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//input[@formcontrolname=\'userEmail\']")
	WebElement user;
	
	@FindBy(id ="userPassword")
	WebElement password;
	
	
	@FindBy(id = "login")
	WebElement login;
	
	public void LoginPage(String userid,String passwordid)
	{
		user.sendKeys(userid);
		password.sendKeys(passwordid);
		login.click();
	}
	
	public void gothere()
	{
		driver.get("https://rahulshettyacademy.com/client/#/auth/login");
	}
}
