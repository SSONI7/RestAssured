package DataDriven;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XlUtils {
	
	public static FileInputStream fis;
	public static FileOutputStream fos;
	public static XSSFWorkbook wb;
	public static XSSFSheet sh;
	public static XSSFRow rw;
	public static XSSFCell cell;
	

	public static int getRowCount(String xlFile,String xlSheet) throws IOException {
		
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(xlSheet);
		int rowCount = sh.getLastRowNum();
		wb.close();
	    fis.close();
	    return rowCount;
		
	}
	
	public static int getCellCount(String xlFile, String xlSheet, int rownum) throws IOException {
		
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(fis);
		sh = wb.getSheet(xlSheet);
		XSSFRow row = sh.getRow(rownum);
		int CellCount = row.getLastCellNum();
		wb.close();
		fis.close();
		return CellCount;
	}
	
	public static String getData(String xlFile,String xlSheet, int rownum, int column) throws IOException {
		
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(xlSheet);
		sh = wb.getSheet(xlSheet);
		XSSFRow row = sh.getRow(rownum);
		XSSFCell cell = row.getCell(column);
		String data;
	
		try {
			 
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		
		}catch(Exception e) {
			
			data = "";
		}
		return data;
		
	}
	
	public static void setData(String xlFile, String xlSheet, int rownum, int column, String data) throws IOException {
		
		fis = new FileInputStream(xlFile);
		wb = new XSSFWorkbook(xlFile);
		sh = wb.getSheet(xlSheet);
		XSSFRow row = sh.getRow(rownum);
		XSSFCell cell = row.getCell(column);
		cell.setCellValue(data);
		fos = new FileOutputStream(xlFile);
		wb.write(fos);
		wb.close();
		fis.close();
		fos.close();
	}
	

}
