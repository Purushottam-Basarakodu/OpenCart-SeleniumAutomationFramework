package testCases.Validations;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.commonMethods.BaseClass;

public class TC_LoginFunction extends BaseClass {
	
	@Test(groups= {"Sanity","Master"})
	public void LoginTestcase()
	{
		logger.info("***Login Functionality test case is started ");
		
		try {
			
		logger.info("Logging into Homepage");
		HomePage homepage=new HomePage(driver);
		homepage.clickOnMyaccount();
		homepage.clickOnLogin();
		
		logger.info("Landed on Login page and providing login credentials");
		LoginPage loginpage=new LoginPage(driver);
		loginpage.setEmail(p.getProperty("login_email"));
		loginpage.setPassword(p.getProperty("login_pwd"));
		loginpage.ClickOnLoginBtn();
		
		
		logger.info("Logged into My account Page successfully");
		MyAccountPage myacc=new MyAccountPage(driver);
		Boolean expectedresult=myacc.IsMyAccountDisplayed();
		
		Assert.assertTrue(expectedresult);
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		logger.info("***Login Functionality test case is completed ");
	}

}
