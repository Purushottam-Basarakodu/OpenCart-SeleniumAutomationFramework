package testBase.commonMethods;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.github.javafaker.Faker;


public class BaseClass {
	public WebDriver driver;
	public Faker faker;// to generate random data
	public Logger logger;
	public Properties p;
	
	@BeforeClass
	@Parameters({"os","browser"})
	public void setUp(String os, String br) throws IOException
	{
		//loading properties file details
		FileReader file=new FileReader("./src//test//resources//application.properties");
		p=new Properties();
		p.load(file);
		logger=LogManager.getLogger(this.getClass());
		
		switch(br.toLowerCase())
		{
		case "chrome" : driver =new  ChromeDriver();break;
		case "edge" : driver = new EdgeDriver();break;
		case "firefox" : driver =new FirefoxDriver();break;
		default : System.out.println("Invalid browser name");
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(p.getProperty("application_url"));
		driver.manage().window().maximize();
		
	}
	@AfterClass
	public void tearDown()
	{
		driver.close();
	}
	
	//to generate random data using Java utils
	
	public String generateRandomString()
	{
		String random=RandomStringUtils.randomAlphabetic(5);
		return random;
		
	}
	
	public String generateRandomNumber()
	{
		String random=RandomStringUtils.randomNumeric(10);
		return random;
		
	}
	public String generateRandomAlphaNumeric()
	{
		String random1=RandomStringUtils.randomAlphabetic(3);
		String random2=RandomStringUtils.randomNumeric(10);
		return (random1+random2);
		
	}
}