package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashBoard {
	WebDriver driver;

	DashBoard(WebDriver driver) {
		this.driver = driver;
	}

	// Keeping objects property at the top
	private By e_welcome = By.id("welcome");
	private By e_logout = By.linkText("Logout");

	// Respective Method at Below
	public void doLogout() {
		driver.findElement(e_welcome).click();
		driver.findElement(e_logout).click();
	}
}
