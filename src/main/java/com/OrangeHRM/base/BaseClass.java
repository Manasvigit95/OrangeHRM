package com.OrangeHRM.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public WebDriver driver;
	public Properties prop;

	public WebDriver init_driver(Properties prop) {

		String browserName = prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions chromeoptions = new ChromeOptions();
			chromeoptions.addArguments("--disable-notifications");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(chromeoptions);
		} 

		else if(browserName.equalsIgnoreCase("firefox")){
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		}

		else {
			System.out.println("Incorrect Browser" + browserName);
		}

		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;
	}

	public Properties init_prop() throws IOException {
		prop = new Properties();
		FileInputStream ip = new FileInputStream(".\\src\\test\\resources\\config\\config.properties");
		prop.load(ip);

		return prop;
	}

}
