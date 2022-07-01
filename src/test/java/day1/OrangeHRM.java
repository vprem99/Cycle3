package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class OrangeHRM {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".//src//test/resources/drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Opening Browser
		driver.manage().window().maximize(); // Browser will get Maximized
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.name("txtUsername")).sendKeys("admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.className("button")).click();

		driver.findElement(By.id("welcome")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("Logout")).click();

		Thread.sleep(4000);
		driver.quit(); // FOr Closing browser
	}
}
