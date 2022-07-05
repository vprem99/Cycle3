package frameWork;

import org.testng.annotations.Test;

import day3.BaseClass;

public class KeyRunner extends BaseClass {
	@Test
	public void f() {
		UiOperations uio=new UiOperations(driver);
		
		uio.getUtl("https://opensource-demo.orangehrmlive.com/");
		uio.type("name", "txtUsername", "admin");
		uio.type("id", "txtPassword", "admin123");
		uio.click("id", "btnLogin");
		uio.getSnap("src/test/resources/orange.png");
		
		uio.getUtl("http://blazedemo.com");
		uio.selectFromDropDown("name", "fromPort", "Boston");
		uio.click("xpath", "//*[@value='Find Flights']");
		uio.getSnap("src/test/resources/blazedemo.png");



	}
}
