package day5;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	LoginPage(WebDriver driver) {
		this.driver = driver;
	}

	// Keeping objects property at the top
	private By e_un = By.id("txtUsername");
	private By e_pwd = By.id("txtPassword");
	private By e_login = By.id("btnLogin");
	private By e_forget = By.linkText("Forgot your password?");

	// Respective Method at Below
	public void doLogin(String un, String pwd) {
		driver.findElement(e_un).sendKeys(un);
		driver.findElement(e_pwd).sendKeys(pwd);
		driver.findElement(e_login).click();
	}

	public void clickForgot() {
		driver.findElement(e_forget).click();
	}

}
