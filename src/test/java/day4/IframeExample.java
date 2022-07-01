package day4;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import day3.BaseClass;

public class IframeExample extends BaseClass {
	@Test
	public void iframeExample() throws Exception {
		driver.get("file:///D:/Users/Premchand/Desktop/HTML/iframe.html");
		driver.switchTo().frame("hq"); // Swiytching to Iframe using id or Name
		driver.findElement(By.xpath("//span[@class='navbar-toggler-icon']")).click();

		driver.switchTo().defaultContent(); // For Switching to Main Window
		driver.switchTo().frame(1); // Switching ifram using index
		driver.findElement(By.id("gsc-i-id2")).sendKeys("ABC"+Keys.ESCAPE);
		
		new Actions(driver).moveToElement(driver.findElement(By.xpath("//*[text()=' Python']"))).perform();
		Thread.sleep(3000);

		JavascriptExecutor js = (JavascriptExecutor) driver;

		driver.switchTo().defaultContent();
		driver.switchTo().frame(driver.findElement(By.className("demo"))); // Using WebElement
		// driver.findElement(By.id("gsc-i-id1")).sendKeys("Selenium");
		String pid = driver.getWindowHandle();// id of Currently Highlighted Tab/Window

		WebElement E = driver.findElement(By.xpath("//li/a[@data-lasso-id='147432']"));
		js.executeScript("arguments[0].scrollIntoView();", E); // Scrolling to Specific Object

		Actions ac = new Actions(driver); // Actions is used for controlling mouse & Keyboard
		ac.keyDown(Keys.CONTROL).click(E).perform();

		Set<String> allWin = driver.getWindowHandles(); // It id of All Windows/Tab
		System.out.println(pid);
		System.out.println(allWin);
		 ArrayList<String> allWin2=new ArrayList<String>(allWin);
		 
		 driver.switchTo().window(allWin2.get(1)); // It will switch to SecondWindow
		 System.out.println(driver.getTitle());
		 Thread.sleep(2000);
		 driver.close();  // It closes the highlighted Tab/ Window

	}
	
	//
}