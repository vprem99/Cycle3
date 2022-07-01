package day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FirstScript {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "D:\\Users\\Premchand\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();  // Opening Browser
		driver.manage().window().maximize();  // Browser will get Maximized
		driver.get("http://selenium.dev");
		
		String title=driver.getTitle();
		System.out.println("You are on "+title+" Page");
		
		//int a=10;
		//WebElement E= driver.findElement(By.linkText("Downloads"));
		//E.click();  // For Clicking
		
		driver.findElement(By.linkText("Downloads")).click();
		System.out.println("You are on "+driver.getTitle()+" Page");
		Thread.sleep(4000);
		driver.quit();  // FOr Closing browser
	}
}
