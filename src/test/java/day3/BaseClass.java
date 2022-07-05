package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class BaseClass {
	public WebDriver driver;
	public Properties prop;
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			TakesScreenshot ts = (TakesScreenshot) driver;
			File src = ts.getScreenshotAs(OutputType.FILE); // taking location in file type of Object
			FileHandler.copy(src, new File("src/test/resources/" + result.getName() + ".png"));
		}
	}

	@BeforeClass(alwaysRun = true) // Pre-condition like Starting browser in case of any kind Testing
	public void beforeTest() throws IOException {
		 prop=new Properties();
		prop.load(new FileReader("src/test/resources/config.properties"));
		
		System.out.println(prop.getProperty("url"));
		
		System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}

	@AfterClass(alwaysRun = true) // Post-condition like closing browser
	public void afterTest() throws Exception {
		Thread.sleep(2000);
		driver.quit();
	}

}
