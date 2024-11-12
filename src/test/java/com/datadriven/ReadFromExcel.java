package com.datadriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadFromExcel {

	public void getData(String excelSheetName) throws EncryptedDocumentException, IOException {

		File f = new File(System.getProperty("user.dir") + "\\src\\test\\resources\\properties\\testdata_excel.xlsx");
//		File f = new File("C:\\JAVA_FLM\\workspace\\Selenium_Maven_Training\\src\\test\\resources\\properties\\testdata_excel.xlsx");
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetName);

		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);

		Row rowCells = sheetName.getRow(0);
		int totalColumns = rowCells.getLastCellNum();
		System.out.println(totalColumns);

		DataFormatter format = new DataFormatter();

		String testData[][] = new String[totalRows+1][totalColumns];

		for (int i = 0; i <=totalRows; i++) {
			for (int j = 0; j < totalColumns; j++) {
				testData[i][j] = format.formatCellValue(sheetName.getRow(i).getCell(j));
				System.out.println(testData[i][j]);
			}
		}

//		return testData;
	}

	public static void main(String[] args) throws EncryptedDocumentException, IOException {

		ReadFromExcel read = new ReadFromExcel();
		read.getData("login");

	}

}
