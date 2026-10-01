package com.OrangeHRM.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OrangeHRM.utils.CommonUtils;

public class ApplyLeave {
	
	public WebDriver driver;
	CommonUtils util;
	public Properties prop;
	
	private By leaveBtn = By.linkText("Leave");
	private By applyMenu = By.linkText("Apply");
	private By leaveType = By.xpath("//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']");
	private By selectOption = By.xpath("//*[contains(text(),'CAN - Bereavement')]");
	private By enterDate = By.xpath("//div[@class='oxd-date-input']/input");
	private By enterComment = By.xpath("//textarea[@class= 'oxd-textarea oxd-textarea--active oxd-textarea--resize-vertical']");
	private By applyBtn = By.xpath("//button[@type = 'submit']");
	private By leaveListBTN = By.xpath("//*[contains(text(),'Leave List')]");
	private By msg = By.xpath("//span[@class = 'oxd-text oxd-text--span']");
	
	public ApplyLeave (WebDriver driver) {
		
		this.driver = driver;
		util = new CommonUtils(driver);
		
	}
	
	public String applyLeave(Properties prop) throws IOException, InterruptedException {	

		//find Leave Menu and click on Leave Menu
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement leaveBtn1 = wait.until(ExpectedConditions.elementToBeClickable(leaveBtn));
		
		boolean SB = leaveBtn1.isDisplayed();
		System.out.println(SB);
		leaveBtn1.click();

		//select Apply leave menu
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement applyMenu1 = wait.until(ExpectedConditions.elementToBeClickable(applyMenu));
		
		boolean SB1 = applyMenu1.isDisplayed();
		System.out.println(SB1);
		applyMenu1.click();
		
		//click on the leave type dropdown
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("oxd-form-loader")));

		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement leaveType1 = wait.until(ExpectedConditions.elementToBeClickable(leaveType));
				
		boolean SB2 = leaveType1.isDisplayed();
		System.out.println(SB2);
		leaveType1.click();	
		
		//Select the CAN - Vacation leave type
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement selectOption1 = wait.until(ExpectedConditions.elementToBeClickable(selectOption));
						
		boolean SB3 = selectOption1.isDisplayed();
		System.out.println(SB3);
		selectOption1.click();
		
		//Enter the from date
		util.doSendKeys(enterDate, "2026-09-28");
		
		//Enter the comment
		util.doSendKeys(enterComment, "This is my personal leave.");
		
		//Click on Submit button
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement applyBtn1 = wait.until(ExpectedConditions.elementToBeClickable(applyBtn));
						
		boolean SB4 = applyBtn1.isDisplayed();
		System.out.println(SB4);
		applyBtn1.click();
		
		//Click on leave list button
		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement leaveListBTN1 = wait.until(ExpectedConditions.elementToBeClickable(leaveListBTN));
								
		boolean SB5 = applyBtn1.isDisplayed();
		System.out.println(SB5);
		leaveListBTN1.click();
		
		String MSG = util.doGetText(msg);
		
		System.out.println(MSG);
		
		Thread.sleep(5000);
		
		return MSG;	

	}
}
