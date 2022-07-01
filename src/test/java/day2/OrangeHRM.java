package day2;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class OrangeHRM {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".//src//test/resources/drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Opening Browser
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);  // Old Syntax
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));  // New Syntax
		//WebDriverWait wt=new WebDriverWait(driver, Duration.ofSeconds(20));
		
		driver.manage().window().maximize(); // Browser will get Maximized
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.name("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.className("button")).click();

		driver.findElement(By.id("welcome")).click();
		//Thread.sleep(2000);
		//wt.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Logout123")));
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(1))
				.ignoring(NoSuchElementException.class)
				.ignoring(StaleElementReferenceException.class); // Declaration of Fluent
																								// Wait

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.linkText("Logout"));
			}
		});
		
		foo.click();
//		driver.findElement(By.linkText("Logout")).click();
		Thread.sleep(4000);
		driver.quit(); // FOr Closing browser
	}
}
