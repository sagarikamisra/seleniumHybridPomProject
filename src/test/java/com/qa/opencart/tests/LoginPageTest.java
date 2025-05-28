package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.baseTest.BaseTest;

public class LoginPageTest extends BaseTest{
	
	

	@Test(priority=1)
	public void loginPageTitle()
	{
		String actualTitle=loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, "Acoutn Login");
		
	}
	
	@Test(priority=2)
	public void loginPageURLTest()
	{
		String actualURL= loginPage.getLoginPageURL();
		Assert.assertTrue(actualURL.contains("/opencart/index.php?route=account/login"));
	}
	
	@Test(priority=3)
	public void ForgotPwdLinkExistTest()
	{
		Assert.assertTrue(loginPage.isForgotPswdLinkExist());
	}
	
	@Test(priority=4)
	public void loginTest()
	{
		accPage=loginPage.doLogin(prop.getProperty("username".trim()),prop.getProperty("password").trim());
	}
	
}
