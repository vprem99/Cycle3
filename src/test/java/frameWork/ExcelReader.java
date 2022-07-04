package frameWork;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	Workbook wb;

	ExcelReader(String pathOfFile) {
		try {
			if (pathOfFile.endsWith(".xlsx")) {
				wb = new XSSFWorkbook(new FileInputStream(pathOfFile));
			} else if (pathOfFile.endsWith(".xls")) {
				wb = new HSSFWorkbook(new FileInputStream(pathOfFile));
			} else
				System.out.println("Invalid File Format");
		}

		catch (Exception E) {
			System.out.println("Error with File Reading" + E.getMessage());
		}
	}

	public String getCellData(String sheetName, int row, int col) {
		Cell data = wb.getSheet(sheetName).getRow(row).getCell(col);
		DataFormatter formatter = new DataFormatter();
		return formatter.formatCellValue(data);
	}

	public int getRowNum(String sheetName) {
		return wb.getSheet(sheetName).getLastRowNum() + 1;
	}

	/*
	 * public String[][] getAllData(String sheetName, int row, int col) {
	 * 
	 * }
	 */

}
