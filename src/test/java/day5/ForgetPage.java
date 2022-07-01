package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgetPage {
	WebDriver driver;

	ForgetPage(WebDriver driver) {
		this.driver = driver;
	}

	// Keeping objects property at the top
	private By e_un = By.id("securityAuthentication_userName");
	private By e_reset = By.id("btnSearchValues");
	private By e_cancel = By.id("btnCancel");

	// Respective Method at Below
	public void doReset(String un) {
		driver.findElement(e_un).sendKeys(un);
		driver.findElement(e_reset).click();
	}

	public void clickCancel() {
		driver.findElement(e_cancel).click();
	}

}
