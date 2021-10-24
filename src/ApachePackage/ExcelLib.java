package ApachePackage;

import java.io.File;
import java.io.FileInputStream;


import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelLib {
	XSSFWorkbook wbk;
	XSSFSheet sheet;
	public ExcelLib(String filepath) {
//		String filepath = "C:\\Users\\vrt999\\Desktop\\ExcelData\\ExcelData.xlsx";
		File inp = new File(filepath);
		try {
			FileInputStream inpstr = new FileInputStream(inp);
			wbk = new XSSFWorkbook(inpstr);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public String getData(int sheetNum,int rowNum,int colNum) {
		sheet = wbk.getSheetAt(sheetNum);
		String data = sheet.getRow(rowNum).getCell(colNum).getStringCellValue().toString();
		return data;
	}
}
