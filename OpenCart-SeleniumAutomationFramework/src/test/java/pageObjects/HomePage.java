package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage

{
	//Constructor for HomePage pageObject elements
	public HomePage(WebDriver driver)
	{
		super(driver);
	}
	
	
	//Locators of HomePage of OpenCart Application
	
	@FindBy(xpath="//*[@title='My Account']") WebElement myAccountElement;
	@FindBy(xpath="//a[normalize-space()='Register']") WebElement RegisterElement;
	
	//Action Methods for WebElements
	
	public void clickOnMyaccount()
	{
		myAccountElement.click();
	}
	public void clickOnRegister()
	{
		RegisterElement.click();
	}
}
