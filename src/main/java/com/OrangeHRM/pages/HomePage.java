package com.OrangeHRM.pages;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.OrangeHRM.utils.CommonUtils;

public class HomePage {

	public WebDriver driver;
	CommonUtils util;
	public Properties prop;


	public HomePage(WebDriver driver) {

		this.driver = driver;
		util = new CommonUtils(driver);

	}

	private By dropDownBtn = By.xpath("//i[@class = 'oxd-icon bi-caret-down-fill oxd-userdropdown-icon']");
	private By logOutBtn = By.xpath("(//a[@class = 'oxd-userdropdown-link'])[4]"); 

	public void logOut(Properties prop) throws InterruptedException {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		util.doClick(dropDownBtn);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		util.doClick(logOutBtn);

		//		List<WebElement> elementList = driver.findElements(By.xpath("//a[@class = 'oxd-userdropdown-link']"));
		//		
		//		//using for loop
		//		for(int i = 0; i < elementList.size(); i++){
		//		Thread.sleep(3000);
		//		System.out.println(i + ":" + elementList.get(i).getText());
		//		}
		//		elementList.get(3).click();
	}

}
