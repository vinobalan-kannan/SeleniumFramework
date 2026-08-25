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

	// List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));
	@FindBy(css = ".col-lg-4")
	List<WebElement> products;

	@FindBy(css = "button[routerlink*=cart]")
	WebElement cartIcon;

	@FindBy(css = ".cart h")
	List<WebElement> cartProducts;

	@FindBy(xpath = "//button[text()='Checkout']")
	WebElement checkoutButton;

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement countrySearch;
	
	@FindBy(css = ".action__submit")
	WebElement submitBttn;

	By productBy = By.cssSelector(".col-lg-4");
	By toClick = By.cssSelector(".col-lg-4 button:last-of-type");
	By spinner = By.cssSelector("ng-animating");
	By checkoutbtn = By.xpath("//button[text()='Checkout']");

	public void login(String emailId, String password) {
		email.sendKeys(emailId);
		psswrd.sendKeys(password);
		login.click();
	}

	public List<WebElement> getProductList() {
		waitForElementToBeClickable(productBy);
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
		prod.findElement(toClick).click();
		waitForElementToBeDisappear(spinner);
	}

	public void clickingCartIcon() {
		cartIcon.click();
	}

	public void getCartProducts(String items) {

		cartProducts.stream().anyMatch(p -> p.getText().equalsIgnoreCase(items));
		scrollBy();
	}

	public void clickCheckoutButton() {
		waitForElementToBeClickable(checkoutbtn);
		checkoutButton.click();
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
	
	public void submitBttn()
	{
		submitBttn.click();
	}
}
