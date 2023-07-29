package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ElementUtil;

public class AccountPage {

	private WebDriver driver;
	private ElementUtil eleUtil;
	
	private By logoutLink = By.linkText("Logout");
	private By accHeaders = By.cssSelector("div#content h2");
	private By search = By.name("search");
	private By myAccountHeader = By.xpath("//h2[text()='My Account']");
	
	public AccountPage(WebDriver driver) {
		this.driver = driver;
		eleUtil = new ElementUtil(driver);
	}


	public String getAccPageTitle() {
		return driver.getTitle();
	}
	
	public String getAccPageUrl() {
		return driver.getCurrentUrl();
	}
	
	public boolean isLogoutLinkExist() {
		return (eleUtil.getElements(logoutLink).size()>0);
	}
	
	public boolean isSearchExist() {
		return eleUtil.getElement(search).isDisplayed();
	}
	
	public boolean isMyAccountHeaderExist() {
		return (eleUtil.getElements(myAccountHeader).size()>0);
	}
	public List<String> getAccountsPageHeadersList() {
		List<WebElement> accHeadersList = eleUtil.waitForElementsVisible(accHeaders, AppConstants.DEFAULT_MEDIUM_TIMEOUT);
		List<String> accHeadersValList  = new ArrayList<String>();
		
		for(WebElement e : accHeadersList) {
			String text = e.getText();
			accHeadersValList.add(text);
		}
		return accHeadersValList;
	}

}
