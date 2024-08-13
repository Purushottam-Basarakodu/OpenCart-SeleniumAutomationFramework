package testCases.Validations;

import static org.testng.Assert.fail;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import com.github.javafaker.Faker;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.commonMethods.BaseClass;

public class TC_AccountRegistration extends BaseClass{
	
	
	@Test(groups= {"Regression","Master"})
	public void AccountRegistrationTest()
	{
		logger.info("*******TestCase AccountRegistrationTest Execution is Started *******");
		try {
		logger.info("Landed on Homepage of the Application");
		HomePage homepage= new HomePage(driver);
		homepage.clickOnMyaccount();
		logger.info("Clicked on My account Link");
		homepage.clickOnRegister();
		logger.info("Clicked on Register Link");
		
		
		logger.info("Providing details for Registering new Account");
		AccountRegistrationPage register= new AccountRegistrationPage(driver);
		register.setFirstName(generateRandomString().toUpperCase());
		register.setLastName(generateRandomString().toUpperCase());
		register.setEmail(generateRandomString()+"@gmail.com");
		register.setTelephoneNumber(generateRandomNumber());
		String passwd=generateRandomAlphaNumeric();
		register.setPassword(passwd);
		register.setConfirmPassword(passwd);
		register.ClickOnSubcribe();
		register.ClickOnCheckBox();
		register.clickOnSubmit();
		
		String title = driver.getTitle();
		
		/*if(title=="Register Account123")
		{
			System.out.println("title matched");
		}
		else
		{
			System.out.println("title unmatched");
		}
		
		
		Assert.assertEquals(driver.getTitle(), "Register Account123");
		System.out.println("this is next line after hard assert");	
		*/
		logger.info("Validating the Title information");
		SoftAssert as=new SoftAssert();
		//System.out.println(driver.getTitle());
		as.assertEquals(driver.getTitle(), "Your Account Has Been Created!");
		System.out.println("this is next line after soft assert");
		
		as.assertAll();
		}
		catch(Exception e)
		{
			Assert.fail("TestCase is failed" + e.getMessage());
		}
	}
	

}
