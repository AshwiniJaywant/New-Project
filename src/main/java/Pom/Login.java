package Pom;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Utility_Class;

public class Login extends Utility_Class{
	WebDriver driver;

    @FindBy(xpath="//span[@class='absolute-center']")
    private WebElement loginButton;
	
	@FindBy(xpath="//input[@id='login_email1']")
	private WebElement email;
	
	@FindBy(xpath="//span[@class='absolute-center']")
	private WebElement continuee;
	
	@FindBy(xpath="//input[@id='login_password1']")
	private WebElement password;
	
	@FindBy(xpath="//div[@class='absolute-center btn51ParentDimension']")
	private WebElement submit;
	
	@FindBy(xpath="(//input[@type='number'])[1]")
	private WebElement pinElement;
	
	
	public Login(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	
	public void putEmail() throws IOException
	{
		loginButton.click();
		String data=getDataFromPropertyFile("email");
		email.sendKeys(data);
		continuee.click();
	}
	
	public void putPassword() throws IOException
	{
		explicitWait(driver, password);
		String data=getDataFromPropertyFile("password");
		password.sendKeys(data);
	}
	
	public void clickSubmitBtn()
	{
		submit.click();
	}
	public void enterPin() throws IOException {
		String pin=getDataFromPropertyFile("pin");
		char c[]=pin.toCharArray();
	
		explicitWait(driver,pinElement);
		List<WebElement> list=driver.findElements(By.xpath("//input[@type='number']"));
				for(int i=0; i<c.length; i++)
				{
					list.get(i).sendKeys(String.valueOf(c[i]));
				}
	}
	
	
	
}
