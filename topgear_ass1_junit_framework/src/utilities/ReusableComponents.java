package utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;


public class ReusableComponents {
	public static Properties prop;
	DataFormatter formatter = new DataFormatter();
	FileInputStream fis;
	
	public String getProperty(String key) throws IOException
	{
		prop = new Properties();
		fis = new FileInputStream("./src\\resources\\data.properties");
		prop.load(fis);
		
		String value = prop.getProperty(key);
		
		return value;
	}
	
	public Object[][] readDatafromExcel(int sheetindex) throws IOException
	{
		XSSFWorkbook workbook = new XSSFWorkbook(getFis("./src\\main\\java\\resources\\Login.xlsx"));
		XSSFSheet sheet = workbook.getSheetAt(sheetindex);
		int rowCount = sheet.getPhysicalNumberOfRows();
		XSSFRow row  = sheet.getRow(0);
		int colCount = row.getLastCellNum();
		
		Object data[][] = new Object[rowCount-1][colCount];
		
		for(int i =0; i<rowCount-1 ; i++)
		{
			row=sheet.getRow(i+1);
			for(int j =0 ; j< colCount; j++ )
			{
				XSSFCell cell = row.getCell(j+1);
				data[i][j] = formatter.formatCellValue(cell);
			}
		}
		workbook.close();
		return data; 
	}
	
	public FileInputStream getFis(String path) throws IOException {
		fis= new FileInputStream(path);
		return fis;
	}
	

}
