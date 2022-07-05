package frameWork;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;

public class UiOperations {

	WebDriver driver;

	UiOperations(WebDriver driver) {
		this.driver = driver;
	}

	public void getUtl(String url) {
		driver.get(url);
	}

	public void click(String locatorType, String locatorValue) {
		WebElement x = getElement(locatorType, locatorValue);
		x.click();
	}

	public void type(String locatorType, String locatorValue, String text) {
		WebElement x = getElement(locatorType, locatorValue);
		x.sendKeys(text);
	}

	public void selectFromDropDown(String locatorType, String locatorValue, String option) {
		Select s = new Select(getElement(locatorType, locatorValue));
		s.selectByVisibleText(option);
	}

	public WebElement getElement(String locatorType, String locatorValue) {
		WebElement E = null;
		if (locatorType.equalsIgnoreCase("id"))
			E = driver.findElement(By.id(locatorValue));
		else if (locatorType.equalsIgnoreCase("name"))
			E = driver.findElement(By.name(locatorValue));
		else if (locatorType.equalsIgnoreCase("link"))
			E = driver.findElement(By.linkText(locatorValue));
		else if (locatorType.equalsIgnoreCase("css"))
			E = driver.findElement(By.cssSelector(locatorValue));
		else if (locatorType.equalsIgnoreCase("xpath"))
			E = driver.findElement(By.xpath(locatorValue));
		else
			System.out.println("Invalid Locator");

		return E;
	}

	public void getSnap(String pathWitName) {
		// WebDriver driver=new ChromeDriver();
		TakesScreenshot tc = (TakesScreenshot) driver;
		File src = tc.getScreenshotAs(OutputType.FILE);
		try {
			FileHandler.copy(src, new File(pathWitName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
