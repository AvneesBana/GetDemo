package com.qa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.logging.FileHandler;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.base.TestBase;

public class TestUtil extends TestBase {

	public TestUtil() throws IOException {
		super();

	}

	static XSSFWorkbook workbook;
	static XSSFSheet sheet;

	public static String TEST_DATA_SHEETPATH = "C:\\Users\\my pc\\Desktop\\TestData.xlsx";

	public static Object[][] getTestData() throws IOException {

		FileInputStream file = null;
		try {
			file = new FileInputStream(TEST_DATA_SHEETPATH);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(0);

		int rowCount = sheet.getLastRowNum();
		int columnCount = sheet.getRow(0).getLastCellNum();

		Object[][] data = new Object[rowCount][columnCount];

		for (int i = 0; i < sheet.getLastRowNum(); i++) {
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++) {

				data[i][j] = sheet.getRow(i + 1).getCell(j).toString();
				// return data;
			}
		}

		return data;
	}

	public static void captureScreenShot(WebDriver driver, String screenshotname) {
		try {

			TakesScreenshot ts = (TakesScreenshot) driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(source, new File("./screenshot/" + screenshotname + System.currentTimeMillis() + ".jpg"));
			System.out.println("Screenshot taken");
		} catch (Exception e) {
			System.out.println("Exception occured :: " + e);
		}

	}

}
