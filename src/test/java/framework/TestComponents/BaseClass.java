package framework.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import framework.PageObjects.LandingPage;

public class BaseClass {

	public WebDriver driver;
	public LandingPage obj;

	public WebDriver intializeDriver() throws IOException {

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"C:\\Users\\Vino\\eclipse-workspace\\SeleniumFramework\\src\\main\\java\\framework\\Resources\\GlobalData.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");

		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}

		else if (browserName.equalsIgnoreCase("edge")) {
		}
		 
		return driver;
	}
	
	@BeforeMethod
	public LandingPage launchingBrowser() throws IOException
	{
		intializeDriver();
		obj=new LandingPage(driver);
		driver.get("https://rahulshettyacademy.com/client");
		return obj;
	}
	
	@AfterMethod
	public void clossingSession()
	{
		driver.close();

	}

}
