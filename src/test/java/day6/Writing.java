package day6;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class Writing {
	@Test
	public void f() throws Exception {
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("D:\\Users\\Premchand\\Desktop\\Selenium\\Data.xlsx"));
		XSSFSheet s = wb.getSheet("Sheet1");
		XSSFCell cell = s.getRow(2).getCell(2);

		DataFormatter formatter = new DataFormatter();
		String data = formatter.formatCellValue(cell);
		System.out.println(data);

		cell.setCellValue(400074);

		s.getRow(2).createCell(3).setCellValue(400074);
		s.createRow(5).createCell(3).setCellValue("Prem");

		wb.cloneSheet(0, "Akshay");
		wb.write(new FileOutputStream("D:\\Users\\Premchand\\Desktop\\Selenium\\Data.xlsx"));

	}
}
