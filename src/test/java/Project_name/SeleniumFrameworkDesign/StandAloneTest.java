package Project_name.SeleniumFrameworkDesign;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import seleniumFrameworkDesign.pageobjects.LandingPage;
import seleniumFrameworkDesign.pageobjects.ProductCatalogue;


public class StandAloneTest {
	

public class SanityTest {

    @Test
    public void sampleTest() {

    	   
    	        WebDriver driver = new ChromeDriver();
    	        driver.manage().window().maximize();
    	        driver.get("https://www.example.com");
    	        System.out.println("Page title: " + driver.getTitle());
    	        driver.quit();

    }
}

	@Test
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver  = new ChromeDriver();
		//Pageobjects

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		LandingPage Landingpage = new LandingPage(driver);
		Landingpage.gothere();
		Landingpage.LoginPage("batman@batman.com", "Batman@1234");
		ProductCatalogue productcatlogue = new ProductCatalogue(driver);
		List<WebElement>productss = productcatlogue.productwaitlist();
		productcatlogue.addproductstocart(null);
		
		
		/*WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container"))); */
		
		Thread.sleep(1000);
		
	//	WebElement prod2 = products.stream().filter(p->p.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst().orElse(null);
		
	//	prod2.findElement(By.cssSelector(".card-body button:last-of-type")).click();
		Thread.sleep(5000);
	//	driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		productcatlogue.cartheader();
		List<WebElement> check = driver.findElements(By.xpath("//*[@class ='cartSection']//h3"));
		Boolean match = check.stream().anyMatch(s->s.findElement(By.xpath("//*[@class ='cartSection']//h3")).getText().equals("ZARA COAT 3"));
		
		Assert.assertTrue(match);
		
		List<WebElement> check_2 = driver.findElements(By.xpath("//*[@class ='cartSection']//h3"));
		//Boolean match_2 = check_2.stream().anyMatch(s->s.findElement(By.xpath("//*[@class ='cartSection']//h3")).getText().equalsIgnoreCase("ADIDAS ORIGINAL"));
		//Assert.assertTrue(match_2);		
		WebElement checkout = driver.findElement(By.cssSelector(".totalRow button"));
		JavascriptExecutor js = (JavascriptExecutor) driver;

		js.executeScript("arguments[0].click();", checkout);
		
		driver.findElement(By.cssSelector("input[placeholder='Select Country']")).sendKeys("Ind");
		
		
		//Wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		
		driver.findElement(By.xpath("(//button[contains(@class, 'ta-item')])[2]")).click();
		driver.findElement(By.cssSelector(".action__submit")).click();
		String gettext = driver.findElement(By.cssSelector(".hero-primary")).getText();
		System.out.println(gettext);
		Assert.assertTrue(true, gettext);
		
}
}
