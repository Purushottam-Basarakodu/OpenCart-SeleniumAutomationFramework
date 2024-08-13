package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

	public MyAccountPage(WebDriver driver) {
		super(driver);
	}
	
	//Locators
	
	@FindBy(xpath="//h2[text()='My Account']") WebElement MyAccountTitleElement;
	@FindBy(xpath="//div/a[text()='Logout']") WebElement LogoutElement;
	
	//Action method
	
	public boolean IsMyAccountDisplayed()
	{
		try
		{
			return (MyAccountTitleElement.isDisplayed());
		}
		catch(Exception e)
		{
			return false;
		}
	}
	public void clickOnLogout() {
		
		LogoutElement.click();
	}
}
