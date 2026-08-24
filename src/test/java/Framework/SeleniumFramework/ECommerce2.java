package Framework.SeleniumFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Framework.SeleniumFramework.PageObjects.Login;

public class ECommerce2 {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new ChromeDriver();
		
		Login obj =new Login(driver);
			
		String items = "ZARA COAT 3";
		
		String country="India";

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/client");
	
		obj.login("shield@gmail.com", "Captain@123");
		
		List <WebElement> products= obj.getProductList();
		
		obj.addToCart(items);
		
		obj.clickingCartIcon();
		
		obj.getCartProducts(items);
		
		obj.clickCheckoutButton();
		
		obj.setCountry(country);

		obj.submitBttn();
//		
//		List<WebElement> cartProducts = driver.findElements(By.cssSelector(".cart h3"));
//
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//
//		js.executeScript("window.scrollBy(0,500)");
//
//		cartProducts.stream().anyMatch(p -> p.getText().equalsIgnoreCase(items));
//
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Checkout']")));
//
//		driver.findElement(By.xpath("//button[text()='Checkout']")).click();
//
//		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
//
//		String country = "India";
//		List<WebElement> countryList = driver
//				.findElements(By.xpath("//input[@placeholder='Select Country'] / following-sibling::section/button"));
//
//		for (int i = 0; i < countryList.size(); i++) {
//
//			if (countryList.get(i).getText().equalsIgnoreCase(country)) {
//				countryList.get(i).click();
//			}
//		}
//
//		driver.findElement(By.cssSelector(".action__submit")).click();

		driver.quit();

	}

}

//Another ways 
//for (int i = 0; i < products.size(); i++) {
// 1. Store the web element once to avoid multiple DOM searches
//WebElement currentProduct = products.get(i);
//String productName = currentProduct.findElement(By.cssSelector("b")).getText().trim();
//
//// 2. Direct, clean boolean check
//if (items.contains(productName)) {
//	// 3. Click the add-to-cart button
//	currentProduct.findElement(By.cssSelector(".col-lg-4 button:last-of-type")).click();
//
//	// 4. INDUSTRY STANDARD: Only wait AFTER an action causes the loading spinner to
//	// appear
//	wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".ng-animating")));
//}
//}

//products.stream().filter(p -> items.contains(p.findElement(By.cssSelector("b")).getText()))
//.forEach(prod -> prod.findElement(By.cssSelector(".col-lg-4 button:last-of-type")).click());