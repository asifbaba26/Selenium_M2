package com.datadriven;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteToExcel {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet1 = workbook.createSheet("Sheet2");

		Row row0 = sheet1.createRow(0);
		Cell cell0 = row0.createCell(0);

		cell0.setCellValue("Baba");

		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\write_testdata_excel.xlsx");
//		File f = new File("C:\\JAVA_FLM\\workspace\\Selenium_Maven_Training\\src\\test\\resources\\properties\\WriteToExcel.xlsx");

		FileOutputStream fos = new FileOutputStream(f);

		workbook.write(fos);

		fos.close();

		workbook.close();

		System.out.println("Data written into Excel");

	}
}
