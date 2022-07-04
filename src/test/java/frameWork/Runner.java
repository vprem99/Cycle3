package frameWork;

public class Runner {

	public static void main(String[] args) {

		ExcelReader ex=new ExcelReader("D:\\Users\\Premchand\\Desktop\\Selenium\\Data.xls");
		
		System.out.println(ex.getCellData("Sheet1", 4, 1));
		
	}

}
