package ApachePackage;

import java.io.FileInputStream;
import java.util.Arrays;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws Exception {
		String filepath = "C:\\Users\\vrt999\\Desktop\\ExcelData.xlsx";
		
		FileInputStream fin = new FileInputStream(filepath);
		XSSFWorkbook w = new XSSFWorkbook(fin);
		XSSFSheet s = w.getSheet("Sheet1");
		
		int rowcount = s.getLastRowNum();
		XSSFRow r = s.getRow(0);
		int colcount = r.getLastCellNum();
		String[][] data = new String[rowcount][colcount];
		for(int i=1;i<= rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				r = s.getRow(i);
				data[i-1][j] = r.getCell(j).getStringCellValue();				
			}
		}
		
		w.close();
		System.out.println("The data collected:  " + Arrays.deepToString(data));
//		return data;
		
		/*File Fun = new File("C:\\Users\\vrt999\\Desktop\\ExcelData.xlsx");
		FileInputStream Fil = new FileInputStream(Fun);
		XSSFWorkbook data = new XSSFWorkbook(Fil);
		XSSFSheet tab = data.getSheet("Sheet1");
		int rowcount = tab.getLastRowNum();
		XSSFRow r = tab.getRow(0);
		int colcount = r.getLastCellNum();
		System.out.println("The no of rows in the sheet: " + rowcount);
		System.out.println("The no of cols in the sheet: " + colcount);
		String[][] output = new String[rowcount][colcount];
		for(int i=1;i<= rowcount;i++) {
			for(int j=0;j<colcount;j++) {
				r = tab.getRow(i);
				output[i-1][j] = r.getCell(j).getStringCellValue();				
			}
		}


	System.out.println("The data collected:  " + Arrays.deepToString(output));*/
	}

}
