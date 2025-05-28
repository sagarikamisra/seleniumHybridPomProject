package com.qa.opencart.baseTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
import com.qa.opencart.pages.LoginPage;

public class BaseTest {
	
	DriverFactory df;
	WebDriver driver;
	protected Properties prop;
	protected LoginPage loginPage;
	protected AccountsPage accPage;
	
	@BeforeTest
	public void setup()
	{
		df= new DriverFactory();
		prop=df.initProp();
		driver= df.intCriver(prop);
		loginPage=new LoginPage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
	
	

}
