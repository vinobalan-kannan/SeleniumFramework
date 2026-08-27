package framework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage extends Utilities {

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".col-lg-4")
	List<WebElement> products;

	@FindBy(css = ".col-lg-4 button:last-of-type")
	WebElement addToCart;

	By toClick = By.cssSelector(".col-lg-4 button:last-of-type");

	By spinner = By.cssSelector("ng-animating");

	public List<WebElement> getProductList() {
		waitForvisibilityOfAllElements(products);
		// waitForElementToBeClickable(products);
		return products;
	}

//	public WebElement getProductByName(String items)
//	{
//		WebElement prod = products.stream().filter(p -> p.findElement(By.cssSelector("b")).getText().equals(items))
//				.findFirst().orElse(null);
//		
//		return prod;
//	}

	public void addToCart(String items) {
		WebElement prod = products.stream().filter(p -> p.findElement(By.cssSelector("b")).getText().equals(items))
				.findFirst().orElse(null);
		// WebElement prod= getProductByName(items);
		waitForElementToBeClickable(addToCart);
		prod.findElement(toClick).click();
		waitForElementToBeDisappear(spinner);
	}

}
