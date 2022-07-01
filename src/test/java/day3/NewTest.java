package day3;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;

public class NewTest extends BaseClass {
	@Test(dataProvider = "dp")
	public void loginTest(String un, String pwd) {
		driver.get("https://opensource-demo.orangehrmlive.com/");

		driver.findElement(By.name("txtUsername")).sendKeys(un);
		driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		driver.findElement(By.className("button")).click();

		driver.findElement(By.id("welcome")).click();

		driver.findElement(By.linkText("Logout")).click();
	}

	@DataProvider
	public Object[][] dp() {
		// Rows col
		Object data[][] = new Object[4][2];
		data[0][0] = "admin";
		data[0][1] = "admin123";
		data[1][0] = "hr";
		data[1][1] = "hr123";
		data[2][0] = "demo";
		data[2][1] = "demo123";
		data[3][0] = "prem";
		data[3][1] = "prem123";
		return data;
	}
}
/*
 * Data-Driven Testing: --------------------- Performing same steps with
 * different set of data but number f=of execution cycle will depends on number
 * of data.
 * 
 * Generally Data will be seperated from code since Data will be huge
 * 
 * Code Data Java Script Excel Java Script DataBase Java Script JSON file Java
 * Script DataProvider in TestNG Java Script CSV file
 * 
 * 
 * 
 * Java Code				Apache POI			Excel
 * 
 * 
 */