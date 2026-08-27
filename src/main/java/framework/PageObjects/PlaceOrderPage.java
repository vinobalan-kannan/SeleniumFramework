package framework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage extends Utilities {

	WebDriver driver;

	public PlaceOrderPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countrySearch;

	@FindBy(css = ".action__submit")
	WebElement submitBttn;

	By placeOrderWait = By.xpath("//h1[contains(text(),'Thankyou')]");

	// waitForElementToBeClickable(checkoutbtnWait);
	// checkoutButton.click();
	// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
	// checkoutButton);

	public void setCountry(String country) {
		countrySearch.sendKeys(country);

		List<WebElement> countryList = driver
				.findElements(By.xpath("//input[@placeholder='Select Country'] / following-sibling::section/button"));

		for (int i = 0; i < countryList.size(); i++) {

			if (countryList.get(i).getText().equalsIgnoreCase(country)) {
				countryList.get(i).click();
			}
		}
	}

	public void submitBttn() {
		safeClick(submitBttn);
		// waitForElementToBeClickable(submitBtnWait);
		// submitBttn.click();
	}

}
