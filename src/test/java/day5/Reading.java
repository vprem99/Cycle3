package day5;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Reading {
	@Test
	public void f() throws Exception {
		// Reading WorkBook
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("D:\\Users\\Premchand\\Desktop\\Selenium\\Data.xlsx"));
		// Reading Sheet
		XSSFSheet sh = wb.getSheet("Sheet1");

		// Reading Cell
		String data = sh.getRow(2).getCell(1).toString();
		System.out.println(data);

		int rows = sh.getLastRowNum(); // Index of Last Row
		System.out.println("Total available rows are " + rows);
		int col = sh.getRow(0).getLastCellNum(); // it gives actual number of column
		System.out.println(col);

		for (int i = 0; i <= rows; i++) {
			// System.out.print(sh.getRow(i).getCell(0).toString()+" ");
			// System.out.print(sh.getRow(i).getCell(1).toString()+" ");
			// System.out.println(sh.getRow(i).getCell(2).toString());
			for (int j = 0; j < col; j++) {
				System.out.print(sh.getRow(i).getCell(j).toString()+" ");
			}
			System.out.println();
		}

	}
}
