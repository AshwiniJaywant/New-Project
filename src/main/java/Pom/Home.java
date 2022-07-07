package Pom;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Utility.Utility_Class;

public class Home extends Utility_Class{
	WebDriver driver;
	
	@FindBy(xpath="//div[@class='valign-wrapper']/div")
	private WebElement profileIcon;

	@FindBy(xpath="//p[@class='truncate headerDggnd']")
	private WebElement userEmail;

	@FindBy(xpath="//div[@class='valign-wrapper balance-wrap']")
	private WebElement fundButton;


	public Home(WebDriver driver) {
	PageFactory.initElements(driver, this);
	this.driver=driver;
}

	public void clickIcon() {
		profileIcon.click();
	}

	public boolean verifyUserValidateProfile() throws IOException{
		WebElement Element=explicitWait(driver,userEmail);
		String Email=Element.getText();
		String EmailFile=getDataFromPropertyFile("email");
		
		if(Email.equals(EmailFile)) {
			return true;
		}
		else 
		{
			return false;
		}
	}
		public void clickFundButton() {
			fundButton.click();
		}
		
	
}
