package framework.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage extends Utilities {

	WebDriver driver;

	public ConfirmationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//h1[contains(text(),'Thankyou')]")
	WebElement placeOrderBttn;

	public Boolean verifyConfirmation(String confirmationText) {
		safeClick(placeOrderBttn);

		Boolean confirmationmsgg = confirmationText
				.equalsIgnoreCase(driver.findElement(By.xpath("//h1[contains(text(),'Thankyou')]")).getText().trim());

		return confirmationmsgg;
	}
}
