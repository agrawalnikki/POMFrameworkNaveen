package com.qa.opencart.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;

public class LoginPageTest extends BaseTest{

	@Test(priority=1)
	public void loginTest(){
		accountPage = loginPage.doLogin(prop.getProperty("username").trim(), prop.getProperty("password").trim());
		Assert.assertTrue(accountPage.isLogoutLinkExist(), "Please enter valid UserID and Password");	
	}
	
	@Test
	public void loginPageTitleTest(){
		String actualTitle = loginPage.getLoginPageTitle();
		Assert.assertEquals(actualTitle, AppConstants.LOGIN_PAGE_TITLE_VALUE);
	}
	
	@Test
	public void loginPageUrlTest(){
		String actualUrl = loginPage.getLoginPageUrl();
		Assert.assertTrue(actualUrl.contains(AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE));
	}
	
}
