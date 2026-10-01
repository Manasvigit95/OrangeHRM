package com.OrangeHRM.pages;

import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OrangeHRM.utils.CommonUtils;

public class PIMPage {
	
	public WebDriver driver;
	CommonUtils util;
	public Properties prop;
	
	
	private By PIMBtn = By.xpath("//span[text()='PIM']");
	private By AddBtn = By.xpath("//a[text() = 'Add Employee']");
	private By EmpFirstName = By.xpath("//input[@name = 'firstName']");
	private By EmpMiddleName = By.xpath("//input[@name = 'middleName']");
	private By EmpLastName = By.xpath("//input[@name = 'lastName']");
	private By EmpID = By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[2]");
	private By SaveBtn = By.xpath("//button[@type = 'submit']");
	
	private By Header = By.xpath("//*[contains(text(),'Personal Details')]");
	


	public PIMPage(WebDriver driver) {

		this.driver = driver;
		util = new CommonUtils(driver);

	}
	
	public String createEmployee(Properties prop) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement PIMBtn1 = wait.until(ExpectedConditions.elementToBeClickable(PIMBtn));

		boolean SB = PIMBtn1.isDisplayed();
		System.out.println(SB);
		PIMBtn1.click();
		//util.doClick(PIMBtn);
		
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement AddBtn1 = wait1.until(ExpectedConditions.elementToBeClickable(AddBtn));

		boolean SB1 = AddBtn1.isDisplayed();
		System.out.println(SB1);
		AddBtn1.click();
		//util.doClick(AddBtn);
		util.doSendKeys(EmpFirstName, "Lalita");
		util.doSendKeys(EmpMiddleName, "Kartik");
		util.doSendKeys(EmpLastName, "Bakshi");
		util.doSendKeys(EmpID, "1234");
		util.doClick(SaveBtn);
		
		String confirmMessage = util.doGetText(Header);
		
		return confirmMessage;
		
	}
	
	public void searchEmployee() {
		
		
	}

}
