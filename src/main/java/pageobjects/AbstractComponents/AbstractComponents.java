package pageobjects.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	WebDriver driver;
	
	@FindBy(xpath = "//button[@routerlink='/dashboard/cart']")
	WebElement cartheader;
	
	
	public AbstractComponents(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void waitthis(By findBy)
	{
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
	}

	public void cartheader()
	{
		cartheader.click();
	}
}
