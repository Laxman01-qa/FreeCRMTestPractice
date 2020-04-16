package com.crm.qa.utilpractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

import com.crm.qa.basepractice.TestBasePractice;

public class TestUtilPractice extends TestBasePractice {
	
	public static long IMPLICT_WAIT = 50;
	public static long PAGE_LOAD_TIME = 50;
	
	String TEST_DATA_PATH = "C:/Selenium Practice/FreeCRMTestPractice/src"
			+ "/main/java/com/crm/qa/testdata/PracticeTestData.xls";
	
	static Workbook book;
	static Sheet sheet;
	
	public void switchToFrame(){
		driver.switchTo().frame("mainpanel");
	}
	
	@DataProvider
	public Object[][] getTestData(String sheetName) throws EncryptedDocumentException, IOException{
		FileInputStream file = null;
		file = new FileInputStream(TEST_DATA_PATH);
		book = WorkbookFactory.create(file);
		sheet =book.getSheet(sheetName);
		
		String inputData[][] = new String [sheet.getLastRowNum()] [sheet.getRow(0).getLastCellNum()];
		for (int i = 0; i < sheet.getLastRowNum(); i++){
			for (int j = 0; j < sheet.getRow(0).getLastCellNum(); j++){
				inputData[i][j] = sheet.getRow(i + 1).getCell(j).getStringCellValue();
			}
			
		}
		return inputData;
	}

}
