package day5;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import day3.BaseClass;

public class Runner extends BaseClass {
	LoginPage lp;

	@Test
	public void forgetLinkCheck() {
		driver.get("https://opensource-demo.orangehrmlive.com/");
		lp = new LoginPage(driver);
		lp.clickForgot();

		Assert.assertTrue(driver.getCurrentUrl().contains("requestPasswordResetCode"), "Forget Page did not open");
	}

	@Test(dependsOnMethods = "forgetLinkCheck")
	public void forgetPageCancelCheck() {
		ForgetPage lp = new ForgetPage(driver);
		lp.clickCancel();

		Assert.assertTrue(driver.getCurrentUrl().contains("login"), "Login Page did not open");
	}

	@Test(dependsOnMethods = "forgetPageCancelCheck")
	public void loginCheck() {
		lp.doLogin("admin", "admin123");

		Assert.assertTrue(driver.getCurrentUrl().contains("dashboard"), "Login did not Happened");
	}
}
