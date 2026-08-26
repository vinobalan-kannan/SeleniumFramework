package framework.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Utilities {

	WebDriver driver;

	public Login(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement email;

	@FindBy(id = "userPassword")
	WebElement psswrd;

	@FindBy(name = "login")
	WebElement login;

	@FindBy(css = ".col-lg-4")
	List<WebElement> products;

	@FindBy(css = ".col-lg-4 button:last-of-type")
	WebElement addToCart;

	@FindBy(css = "button[routerlink*=cart]")
	WebElement cartIcon;

	@FindBy(css = ".cart h3")
	List<WebElement> cartProducts;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkoutButton;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countrySearch;

	@FindBy(css = ".action__submit")
	WebElement submitBttn;

	@FindBy(xpath = "//h1[contains(text(),'Thankyou')]")
	WebElement placeOrderBttn;

	By productBy = By.cssSelector(".col-lg-4");
	By toClick = By.cssSelector(".col-lg-4 button:last-of-type");
	By cartIconWait = By.cssSelector("button[routerlink*=cart]");
	By spinner = By.cssSelector("ng-animating");
	By checkoutbtnWait = By.xpath("//button[text()='Checkout']");
	By placeOrderWait = By.xpath("//h1[contains(text(),'Thankyou')]");
	By submitBtnWait = By.cssSelector(".action__submit");

	public void login(String emailId, String password) {
		email.sendKeys(emailId);
		psswrd.sendKeys(password);
		login.click();
	}

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

	public void clickingCartIcon() throws InterruptedException {
		safeClick(cartIcon);
		scrollBy(checkoutButton);
		// waitForElementToBeClickable(cartIconWait);
		// cartIcon.click();
		// waitForElementToBeVisible(checkoutbtnWait);

	}

	public boolean getCartProducts(String items) {

		boolean cartItems = cartProducts.stream().anyMatch(p -> p.getText().equalsIgnoreCase(items));
		return cartItems;
	}

	public void clickCheckoutButton() throws InterruptedException {
		safeClick(checkoutButton);
		//waitForElementToBeClickable(checkoutbtnWait);
		//checkoutButton.click();
		// ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
		// checkoutButton);
	}

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
		//waitForElementToBeClickable(submitBtnWait);
		//submitBttn.click();
	}

	public Boolean verifyConfirmation(String confirmationText) {
		safeClick(placeOrderBttn);
		//waitForElementToBeClickable(placeOrderWait);

		//placeOrderBttn.click();

		Boolean confirmationmsgg = confirmationText
				.equalsIgnoreCase(driver.findElement(By.xpath("//h1[contains(text(),'Thankyou')]")).getText().trim());

		return confirmationmsgg;
	}
}
