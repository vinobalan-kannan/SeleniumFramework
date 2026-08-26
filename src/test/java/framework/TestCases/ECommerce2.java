package framework.TestCases;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import framework.PageObjects.Login;
import framework.TestComponents.BaseClass;

public class ECommerce2 extends BaseClass {

	@Test
	public void submitOrder() throws IOException, InterruptedException {

		String items = "ZARA COAT 3";

		String country = "India";

		String confirmationText = "Thankyou for the order.";

		//Login obj = launchingBrowser();

		obj.login("shield@gmail.com", "Captain@123");

		obj.addToCart(items);

		obj.clickingCartIcon();

		Assert.assertTrue(obj.getCartProducts(items));

		obj.clickCheckoutButton();

		obj.setCountry(country);

		obj.submitBttn();

		Assert.assertTrue(obj.verifyConfirmation(confirmationText));
//		
		
//		
//		
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