package com.qa.opencart.tests;

import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.baseTest.BaseTest;
import com.qa.opencart.pages.LoginPage;
import com.qa.opencat.appConstant.AppConstants;

public class AccountsPageTest extends BaseTest{
	
	private static final String AppConstant = null;
	@BeforeClass
	public void accPageSetUp()
	{
		accPage=loginPage.doLogin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
	}
	@Test
	public void accPageTitleTest()
	{
		String actualTitle= accPage.getAccPageTitle();
		Assert.assertEquals(actualTitle,"My Account");
	}
	@Test
	public void accPageURLTest()
	{
		String actualURL=accPage.getAccPageURL();
		Assert.assertTrue(actualURL.contains("route=account/account"));
	}
	@Test
	public void aacPageLogoutLinkTest()
	{
		 Assert.assertTrue(accPage.isLogoutLinkExist());
	}
	@Test
	public void accPageHeadersTest()
	{
		List<String> actualHeadersList=accPage.getAccountsPageHeadersList();
		Assert.assertEquals(actualHeadersList.size(), AppConstants.ACCOUNTS_PAGE_HEADERS_COUNT);
	}
	
	@Test
	public void accPageHeadersValueTest()
	{
		List<String> actualHeadersList=accPage.getAccountsPageHeadersList();
		System.out.println("Actual header list::"+actualHeadersList);	
		System.out.println("Expected header list::"+AppConstants.EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST);	
		Assert.assertEquals(actualHeadersList, AppConstants.EXPECTED_ACCOUNTS_PAGE_HEADERS_LIST);
	}
}
