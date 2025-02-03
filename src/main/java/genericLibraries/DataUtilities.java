package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtilities {
	public String readDataPropertyFile(String data) throws FileNotFoundException, IOException {
		Properties properties = new Properties();
		properties.load(new FileInputStream(AutoConstant.propertiesFilePath));
		return properties.getProperty(data);
	}
 
	public String readDataExcelFile(String sheetName, int rowNumber, int cellNumber)
			throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(AutoConstant.excelShettPath);
		Workbook workbook = WorkbookFactory.create(fis);
		return workbook.getSheet(sheetName).getRow(rowNumber).getCell(cellNumber).getStringCellValue();
	}
}
