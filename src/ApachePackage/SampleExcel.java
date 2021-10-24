package ApachePackage;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class SampleExcel {

	public static void main(String[] args) throws Exception {
//		File f = new File("C:\\Users\\vrt999\\Desktop\\abcd.xls");
		
//		To read a file u need fin in the HSSFWorkBook object
//		To create a new Excel Workbook creae an empty wokrbook with out any fin and then perform fout
		
		FileInputStream fin = new FileInputStream("C:\\Users\\vrt999\\Desktop\\abcd.xls");
		
		HSSFWorkbook w = new HSSFWorkbook(fin);
		HSSFSheet  sh = w.createSheet("Teja");
		HSSFRow r = sh.createRow(0);
		HSSFCell c = r.createCell(0);
		c.setCellValue("Teja");
		
		FileOutputStream fout = new FileOutputStream("C:\\Users\\vrt999\\Desktop\\abcd.xls");
		w.write(fout);
		w.close();
		fout.close();
		System.out.println("File closed");
		
		
		
		

	}

}
