package com.qa.opencart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class LoginPage {

	private WebDriver driver;
	private ElementUtil eleUtil;

	// 1.Private By locators
	private By emailId = By.id("input-email");
	private By password = By.id("input-password");
	private By loginBtn = By.xpath("//input[@value='Login']");
	private By forgotPwdLink = By.linkText("Forgotten Password");

	// 2. Constructor
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}

	// 3. Page Actions

	public String getLoginPageTitle() {
		return eleUtil.waitForTitleIsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT, AppConstants.LOGIN_PAGE_TITLE_VALUE);
		
	}
	
	public String getLoginPageUrl() {
		return eleUtil.waitForURLContainsAndFetch(AppConstants.DEFAULT_MEDIUM_TIMEOUT, AppConstants.LOGIN_PAGE_URL_FRACTION_VALUE);
	}
	
	public boolean isForgotPwdLinkExist() {
		return eleUtil.waitForElementVisible(forgotPwdLink, AppConstants.DEFAULT_SHORT_TIMEOUT).isDisplayed();
	}
	
	public AccountPage doLogin(String un, String pwd){
		eleUtil.waitForElementVisible(emailId, AppConstants.DEFAULT_MEDIUM_TIMEOUT).sendKeys(un);
		eleUtil.doSendKeys(password, pwd);
		eleUtil.doClick(loginBtn);
		return new AccountPage(driver);
//		if(eleUtil.getElements(myAccountHeader).size()>0)
//			return new AccountPage(driver);
//		else {
//			System.out.println("Please pass valid credential");
//			return null;
//		}
			
		}
	}
