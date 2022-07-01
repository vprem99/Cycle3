package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class RegistrationForm {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", ".//src//test/resources/drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Opening Browser
		driver.manage().window().maximize(); // Browser will get Maximized
		driver.get("file:///D:/Users/Premchand/Desktop/HTML/Registration.html");
		
		WebElement course=driver.findElement(By.name("edu"));
		Select sc=new Select(course);
		
		//sc.selectByVisibleText("MBA");
		//sc.selectByIndex(3);
		sc.selectByValue("M3");
		
		System.out.println("Multi Select option is "+sc.isMultiple());

		
		Thread.sleep(4000);
		driver.quit(); // FOr Closing browser
	}
}
