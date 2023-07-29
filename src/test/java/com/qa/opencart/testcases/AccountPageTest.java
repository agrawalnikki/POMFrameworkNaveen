package com.qa.opencart.testcases;

import java.util.Collections;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class AccountPageTest extends BaseTest{

	@BeforeClass
	public void accPageSetUp() {
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accountPage.isLogoutLinkExist(), "Please enter valid UserID and Password");
	}
	
	@Test
	public void accPageTitleTest() {
		String actualTitle = accountPage.getAccPageTitle();
		Assert.assertEquals(actualTitle,AppConstants.ACCOUNT_PAGE_TITLE_VALUE);	
		}
	
	@Test
	public void accPageUrlTest() {
		String actualUrl = accountPage.getAccPageUrl();
		Assert.assertTrue(actualUrl.contains(AppConstants.ACCOUNT_PAGE_URL_FRACTION_VALUE));	
		}
	
	@Test
	public void isLogoutLinkExistTest() {
		Assert.assertTrue(accountPage.isLogoutLinkExist());
	}
	
	@Test
	public void accPageHeadersTest() {
		List<String> actualAccPAgeHeadersList =  accountPage.getAccountsPageHeadersList();
		Assert.assertEquals(actualAccPAgeHeadersList.size(), AppConstants.ACCOUNT_PAGE_HEADERS_COUNT);
	}
	
	//Suppose My Account is coming at the end of the list, but here we have given at first as per the UI now, 
	//so in that case we can sort the array and then compare
	@Test
	public void accPageHeadersValueTest() {
		List<String> actualAccPageHeadersList = accountPage.getAccountsPageHeadersList() ;
		//Collections.sort(actualAccPageHeadersList) ;
		System.out.println("actualAccPageHeadersList: "+actualAccPageHeadersList);
		System.out.println("ExpectedAccPageHeadersList: "+AppConstants.EXPECTED_ACCOUNT_PAGE_HEADERS_LIST);
		Assert.assertEquals(actualAccPageHeadersList, AppConstants.EXPECTED_ACCOUNT_PAGE_HEADERS_LIST);
	}
}
