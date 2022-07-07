package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility_Class {
	public void screenshot(WebDriver driver) throws IOException {
		Date date=new Date();
		SimpleDateFormat f=new SimpleDateFormat("hh-mm-ss");
		String current=f.format(date);
		
		File source=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest=new File("F:\\Screenshot\\Image"+current+".jpg");
		FileHandler.copy(source,dest);
	}
	
		public static  WebElement explicitWait(WebDriver driver,WebElement element) {
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(20));
		WebElement element1=wait.until(ExpectedConditions.visibilityOf(element));
		
		return element1;
		
	}
		public static  String getDataFromExcel(String sheet,int row,int cell) throws IOException {
			FileInputStream file=new FileInputStream("E:\\Book1.xlsx");
			Sheet sheet1=WorkbookFactory.create(file).getSheet(sheet);
			String data=sheet1.getRow(row).getCell(cell).getStringCellValue();
			return data;
		}
		
		public String getDataFromPropertyFile(String key) throws IOException {
			FileInputStream file=new FileInputStream("configration\\config.proprties");
			Properties prop=new Properties();
			prop.load(file);
			String value=prop.getProperty(key);			
			return value;
			
		}
		
	

}
