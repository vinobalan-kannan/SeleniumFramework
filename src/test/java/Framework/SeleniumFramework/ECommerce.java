package Framework.SeleniumFramework;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ECommerce {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/client");

		driver.findElement(By.id("userEmail")).sendKeys("shield@gmail.com");

		driver.findElement(By.id("userPassword")).sendKeys("Captain@123");

		driver.findElement(By.name("login")).click();

		List<WebElement> products = driver.findElements(By.cssSelector(".col-lg-4"));

		WebElement prod = products.stream()
				.filter(p -> p.findElement(By.cssSelector("b")).getText().equals("ADIDAS ORIGINAL")).findFirst()
				.orElse(null);

		prod.findElement(By.cssSelector(".col-lg-4 button:last-of-type")).click();

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

		// driver.quit();
	}

}
