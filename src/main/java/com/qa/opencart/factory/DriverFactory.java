package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	public WebDriver driver;
	public Properties prop;
	public OptionsManager op;
	
	public static String highlight;
	public WebDriver initDriver(Properties prop) {
		
		op = new OptionsManager(prop);
		highlight = prop.getProperty("highlight").trim();
		String browserName = prop.getProperty("browser").toLowerCase().trim();
		System.out.println(browserName);
		
		if(browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver(op.getChromeOptions());
		}
		else if(browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver(op.getFirfoxOptions());
		}
		else {
			System.out.println("Please pass the right browser: "+browserName);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}
	
	public Properties initProp() {
		
		prop = new Properties();
		try {
			System.out.println(System.getProperty("user.dir"));
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop;
	}
}
