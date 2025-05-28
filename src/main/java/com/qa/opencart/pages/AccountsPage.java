package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.appConstant.AppConstants;
import com.qa.opencart.utils.ElementUtils;

public class AccountsPage {
	
	private WebDriver driver;
	private ElementUtils eleUtils;
	
	
	private By logoutLink= By.linkText("Logout");
	private By accHeader= By.cssSelector("div#content h2");
	private By search= By.name("search");
	
	
	public AccountsPage(WebDriver driver)
	{
		this.driver= driver;
		eleUtils=new ElementUtils(driver);
	}
	
	public String getAccPageTitle() {
		String title = eleUtils.waitForTitleIsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.ACCOUNTS_PAGE_TITLE_VALUE);
		System.out.println("Acc page title is : " + title);
		return title;
	}

	public String getAccPageURL() {
		String url = eleUtils.waitForURLContainsAndFetch(AppConstants.DEFAULT_SHORT_TIME_OUT, AppConstants.ACCOUNTS_PAGE_URL_FRACTION_VALUE);
		System.out.println("Acc page url : " + url);
		return url;
	}

	public boolean isLogoutLinkExist() {
		return eleUtils.waitForElementVisible(logoutLink, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
	}

	public boolean isSearchExist() {
		return eleUtils.waitForElementVisible(search, AppConstants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
	}

	public List<String> getAccountsPageHeadersList() {
		List<WebElement> accHeadersList = eleUtils.waitForElementsVisible(accHeader, AppConstants.DEFAULT_MEDIUM_TIME_OUT);		
		List<String> accHeadersValList = new ArrayList<String>();
		for (WebElement e : accHeadersList) {
			String text = e.getText();
			accHeadersValList.add(text);
		}
		return accHeadersValList;
	}
	
	
	/*public SearchPage performSearch(String searchKey) {
		
		if(isSearchExist()) {
			eleUtil.doSendKeys(search, searchKey);
			eleUtil.doClick(searchIcon);
			return new SearchPage(driver);
		}
		else {
			System.out.println("Search field is not present on the page....");
			return null;
		}*/
		
	}
	
	
	
	


