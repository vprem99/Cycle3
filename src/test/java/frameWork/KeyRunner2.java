package frameWork;

import org.testng.annotations.Test;

import day3.BaseClass;

import org.testng.annotations.DataProvider;

public class KeyRunner2 extends BaseClass {
	@Test(dataProvider = "dp")
	public void f(String exKey, String locatorType, String locatorValue, String data) {
		UiOperations uio = new UiOperations(driver);
		if (exKey.equalsIgnoreCase("getSnap"))
			uio.getSnap(data);
		else if (exKey.equalsIgnoreCase("click"))
			uio.click(locatorType, locatorValue);
		else if (exKey.equalsIgnoreCase("type"))
			uio.type(locatorType, locatorValue,data);
		else if (exKey.equalsIgnoreCase("selectFromDropDown"))
			uio.selectFromDropDown(locatorType, locatorValue,data);
		else if (exKey.equalsIgnoreCase("getUrl"))
			uio.getUtl(data);
		else 
			System.out.println("Invalid Key");
		
	}

	@DataProvider
	public Object[][] dp() {

		ExcelReader ex = new ExcelReader(prop.getProperty("excelPath"));
		Object data[][] = new Object[4][4];
		Object data2[][] =ex.getAllData("Sheet2", 4, 4);

		for (int i = 0; i < 4; i++) {
			data[i][0] = ex.getCellData(prop.getProperty("sheetName"), i + 1, 0);
			data[i][1] = ex.getCellData(prop.getProperty("sheetName"), i + 1, 1);
			data[i][2] = ex.getCellData(prop.getProperty("sheetName"), i + 1, 2);
			data[i][3] = ex.getCellData(prop.getProperty("sheetName"), i + 1, 3);
		}
		return data;
	}
}
