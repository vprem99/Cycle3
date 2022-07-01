package day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementsExample {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", ".//src//test/resources/drivers//chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // Opening Browser
		driver.manage().window().maximize(); // Browser will get Maximized
		driver.get("file:///D:/Users/Premchand/Desktop/HTML/Registration.html");

	//	findElememts is used when you want make group of multiple objects
		//having some common property
		
		List<WebElement> ls = driver.findElements(By.name("g"));
		System.out.println("Total radio options are " + ls.size());
		for (int i = 0; i < ls.size(); i++) {
			Thread.sleep(2000);
			ls.get(i).click();
		}
//On login Print total available size of image & print source link from where it is coming
	}

}
