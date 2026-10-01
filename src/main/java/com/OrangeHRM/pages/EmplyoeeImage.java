package com.OrangeHRM.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OrangeHRM.utils.CommonUtils;

public class EmplyoeeImage {
	
	public WebDriver driver;
	CommonUtils util;
	public Properties prop;
	
	private By PIMBtn = By.xpath("//span[text()='PIM']");
	private By Addempbtn = By.xpath("(//a[contains(@class,'oxd-topbar-body-nav-tab-item')])[2]");
	private By EmpFirstName = By.xpath("//input[@name = 'firstName']");
	private By EmpMiddleName = By.xpath("//input[@name = 'middleName']");
	private By EmpLastName = By.xpath("//input[@name = 'lastName']");
	private By EmpID = By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[2]");
	private By SaveBtn = By.xpath("//button[@type = 'submit']");
	private By PhotoUploadbtn =  By.xpath("//i[@class='oxd-icon bi-plus']");
	private By AlertMsg = By.xpath("//p[contains(@class,'oxd-text oxd-text--p oxd-text--card-body')]");
	private By AlertBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	
	private By Header = By.xpath("//*[contains(text(),'Personal Details')]");
	
	public EmplyoeeImage (WebDriver driver) {
		
		this.driver = driver;
		util = new CommonUtils(driver);
		
	}
	
	public String emplyoeeImage(Properties prop) throws IOException, InterruptedException {	

		//find PIM Menu and click on PIM Menu
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement PIMBtn1 = wait.until(ExpectedConditions.elementToBeClickable(PIMBtn));
		
		boolean SB = PIMBtn1.isDisplayed();
		System.out.println(SB);
		PIMBtn1.click();

		//click on Add employee button
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement Addempbtn1 = wait1.until(ExpectedConditions.elementToBeClickable(Addempbtn));

		boolean SB1 = Addempbtn1.isDisplayed();
		System.out.println(SB1);
		Addempbtn1.click();
		
		util.doSendKeys(EmpFirstName, "Lalita");
		util.doSendKeys(EmpMiddleName, "Kartik");
		util.doSendKeys(EmpLastName, "Bakshi");
		util.doSendKeys(EmpID, "1234");
		
		
		//click on Plus button to upload the image
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement PhotoUploadbtn1 = wait2.until(ExpectedConditions.elementToBeClickable(PhotoUploadbtn));

		boolean SB2 = PhotoUploadbtn1.isDisplayed();
		System.out.println(SB2);
		PhotoUploadbtn1.click();
		
		Thread.sleep(5000);//pause of 5 seconds

		Runtime.getRuntime().exec("C://Users//LENOVO//eclipse-workspace//OrangeHRM//AddImageOrangeHRM.exe");

		Thread.sleep(5000);
		
		
		util.doClick(SaveBtn);
		String confirmMessage = util.doGetText(Header);
		
		return confirmMessage;

	}
	
	public void searchEmployee() {
		
		
	}

}
