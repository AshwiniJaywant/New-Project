package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base_Class {
	
	public static WebDriver getDriver(String browser)
	{
		WebDriver driver = null;
		
		if(browser.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver","src\\main\\resources\\Browser\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browser.equals("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver","src\\main\\resources\\Browser\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		}
	
		driver.get("https://groww.in/");
		driver.manage().window().maximize();
		return driver;
		
	}
}
