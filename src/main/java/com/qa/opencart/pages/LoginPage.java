package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.ElementUtils;
import com.qa.opencat.appConstant.AppConstants;

public class LoginPage {
	
	private WebDriver driver;
	private ElementUtils eleUtils;
	
	//1. Private ByLocators
	private By emailId= By.id("input-email");
	private By pswd= By.id("input-password");
	private By loginBtn= By.xpath("//input[@value='Login' and @class='btn btn-primary']");
	private By forgetPswdLink= By.linkText("Forgotten Password");
	
	//2. Page Constructor
	
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		eleUtils= new ElementUtils(driver);
	}
	
	//3.Page actions/method
	
	public String getLoginPageTitle()
	{
		String title= eleUtils.waitForTitleIsAndFetch(AppConstants.DEFAULT_LONG_TIME_OUT, AppConstants.LOGIN_PAGE_TITLE_VALUE);
		System.out.println("Login page title ::"+ title);
		return title;
	}
	
	public String getLoginPageURL()
	{
		//String url= driver.getCurrentUrl();
		String URL=eleUtils.waitForURLIsAndFetch(AppConstants.DEFAULT_LONG_TIME_OUT,AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE);
		System.out.println("Login page title ::"+ URL);
		return URL;
	}
	public boolean isForgotPswdLinkExist()
	{
		return eleUtils.waitForElementVisible(forgetPswdLink, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
	}
	
	public AccountsPage doLogin(String un, String pwd)
	{
		System.out.println("username::"+un +"  "+ "password::"+ pwd);
		eleUtils.waitForElementVisible(emailId, AppConstants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(un);
		eleUtils.doSendKeys(pswd,pwd);
		eleUtils.doClick(loginBtn);
		return new AccountsPage(driver);
	}

}
