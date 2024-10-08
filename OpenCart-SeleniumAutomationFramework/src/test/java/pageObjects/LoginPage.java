package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators details
	
	@FindBy(xpath="//*[@id='input-email']") WebElement inputEmailElement;
	@FindBy(xpath="//*[@id='input-password']") WebElement inputpwdElement;
	@FindBy(xpath="//*[@value='Login']") WebElement BtnLoginElement;
	
	//Action methods
	
	public void setEmail(String email)
	{
		inputEmailElement.sendKeys(email);
	}
	
	public void setPassword(String pwd)
	{
		inputpwdElement.sendKeys(pwd);
	}
	public void ClickOnLoginBtn()
	{
		BtnLoginElement.click();
	}

}
