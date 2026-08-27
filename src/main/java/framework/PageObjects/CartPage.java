package framework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage extends Utilities {

	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cart h3")
	List<WebElement> cartProducts;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkoutButton;

	By checkoutbtnWait = By.xpath("//button[text()='Checkout']");

	public boolean getCartProducts(String items) {

		boolean cartItems = cartProducts.stream().anyMatch(p -> p.getText().equalsIgnoreCase(items));
		return cartItems;
	}

	public void clickCheckoutButton() throws InterruptedException {
		scrollBy(checkoutButton);
		safeClick(checkoutButton);
		// waitForElementToBeClickable(checkoutbtnWait);
		// checkoutButton.click();
		// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		// checkoutButton);
	}

}
