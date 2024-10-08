package testCases.Validations;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.commonMethods.BaseClass;
import utilities.DataProviders;

public class TC_LoginFunctionUsingDDT extends BaseClass {
	
	@Test(dataProvider="LoginDetails",dataProviderClass=DataProviders.class)
	public void LoginTestcase(String emailId,String password,String expected_result)
	{
		logger.info("***Login Functionality test case is started ");
		
		try {
			
		logger.info("Logging into Homepage");
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyaccount();
		homepage.clickOnLogin();
		
		logger.info("Landed on Login page and providing login credentials");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.setEmail(emailId);
		loginpage.setPassword(password);
		loginpage.ClickOnLoginBtn();
		
		
		logger.info("Logged into My account Page successfully");
		MyAccountPage myacc=new MyAccountPage(driver);
		Boolean expectedresult=myacc.IsMyAccountDisplayed();
		
		if(expected_result.equalsIgnoreCase("valid"))
		{
			if(expectedresult==true)
			{
				myacc.clickOnLogout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		if(expected_result.equalsIgnoreCase("Invalid"))
		{
			if(expectedresult==true)
			{
				myacc.clickOnLogout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Login Functionality test case is completed ");
	}

}
