package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage{
	
	
	//Constructor for Account Registration Page
	public AccountRegistrationPage(WebDriver driver) {
		super(driver);
		
	}
	
	//Locators of Account Register page web elements
	
	@FindBy(xpath="//*[@id='input-firstname']") WebElement txt_firstName;
	@FindBy(xpath="//*[@id='input-lastname']") WebElement txt_lastName;
	@FindBy(xpath="//*[@id='input-email']") WebElement txt_email;
	@FindBy(xpath="//*[@id='input-telephone']") WebElement txt_telephone;
	@FindBy(xpath="//*[@id='input-password']") WebElement txt_password;
	@FindBy(xpath="//*[@id='input-confirm']") WebElement txt_confirm_pwd;
	@FindBy(xpath="//*[@checked='checked' and @value='0']") WebElement btn_subscribe;
	@FindBy(xpath="//*[@type='checkbox' and @value='1']") WebElement checkBox_TandC;//T and C stands for terms and conditions
	@FindBy(xpath="//*[@type='submit' and @value='Continue']") WebElement btn_submit;
	
	
	//Actions Methods
	
	public void setFirstName(String firstname)
	{
		txt_firstName.sendKeys(firstname);
	}
	public void setLastName(String lastname)
	{
		txt_lastName.sendKeys(lastname);
	}
	public void setEmail(String email)
	{
		txt_email.sendKeys(email);
	}
	public void setTelephoneNumber(String telePhoneNumber)
	{
		txt_telephone.sendKeys(telePhoneNumber);
	}
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	public void setConfirmPassword(String confirmPassword)
	{
		txt_confirm_pwd.sendKeys(confirmPassword);
	}
	
	public void ClickOnSubcribe()
	{
		btn_subscribe.click();
	}
	public void ClickOnCheckBox()
	{
		checkBox_TandC.click();
	}
	public void clickOnSubmit()
	{
		btn_submit.click();
	}
	
}
