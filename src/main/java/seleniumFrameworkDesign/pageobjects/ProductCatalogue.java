package seleniumFrameworkDesign.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import pageobjects.AbstractComponents.AbstractComponents;

public class ProductCatalogue extends AbstractComponents{

	WebDriver driver;
	public ProductCatalogue(WebDriver driver)
	{	
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".mb-3")
	List<WebElement>  products;
	
	By productsBy = By.cssSelector(".mb-3");
	By addtocart = By.cssSelector(".card-body button:last-of-type");
	By toast = By.id("toast-container");
	public List<WebElement> productwaitlist()
	{
		waitthis(productsBy);
		return products; /* once product are loaded return them */
	}
	
	public WebElement getproductbyname(String productname)
	{
		WebElement prod = productwaitlist().stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals("ZARA COAT 3")).findFirst().orElse(null);
		return prod;
	}
	
	public void addproductstocart(String productname)
	{
		WebElement prod = getproductbyname(productname);
		prod.findElement(addtocart).click();
		waitthis(toast);
	}
	

}

