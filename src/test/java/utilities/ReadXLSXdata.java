package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadXLSXdata {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		ReadXLSXdata red = new ReadXLSXdata();
		red.getdata("login");
		
	}
	
	public String[][] getdata(String excelSheetname) throws EncryptedDocumentException, IOException {
		File filePath = new File(System.getProperty("user.dir")+"/src/test/resources/testdata/testdata.xlsx");
		FileInputStream fis = new FileInputStream(filePath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetName = wb.getSheet(excelSheetname);
		
		int totalRows = sheetName.getLastRowNum();
		System.out.println(totalRows);
		Row rowCells = sheetName.getRow(0);
		int totalColumns = rowCells.getLastCellNum();
		System.out.println(totalColumns);
		
		DataFormatter format = new DataFormatter();
		
		String testdata[][] = new String[totalRows][totalColumns];
		for(int i=1; i<=totalRows; i++) {
			for(int j=0; j<totalColumns; j++) {
			testdata[i-1][j]= format.formatCellValue(sheetName.getRow(i).getCell(j));
			System.out.println(testdata[i-1][j]);
			}
		}
		return testdata;
		
	}

}
