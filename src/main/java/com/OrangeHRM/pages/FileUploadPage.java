package com.OrangeHRM.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.openqa.selenium.Alert;
import com.OrangeHRM.utils.CommonUtils;

public class FileUploadPage {
	
	public WebDriver driver;
	CommonUtils util;
	public Properties prop;
	
	private By PIMBtn = By.xpath("//span[text()='PIM']");
	private By ConBtn = By.xpath("//span[@class='oxd-topbar-body-nav-tab-item']");
	private By Data =  By.partialLinkText("Data ");
	private By BrowseBtn = By.xpath("//div[@class='oxd-file-button']");
	private By UploadBtn = By.xpath("//button[@type='submit']");
	private By AlertMsg = By.xpath("//p[contains(@class,'oxd-text oxd-text--p oxd-text--card-body')]");
	private By AlertBtn = By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--secondary']");
	
	public FileUploadPage (WebDriver driver) {
		
		this.driver = driver;
		util = new CommonUtils(driver);
		
	}
	
	
	public String fileUpload(Properties prop) throws InterruptedException, IOException {	

		//find PIM Menu and click on PIM Menu
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement PIMBtn1 = wait.until(ExpectedConditions.elementToBeClickable(PIMBtn));
		
		boolean SB = PIMBtn1.isDisplayed();
		System.out.println(SB);
		PIMBtn1.click();

		//click on configuration button
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement ConBtn1 = wait1.until(ExpectedConditions.elementToBeClickable(ConBtn));

		boolean SB1 = ConBtn1.isDisplayed();
		System.out.println(SB1);
		ConBtn1.click();
		
		//click on Data import
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement Data1 = wait2.until(ExpectedConditions.elementToBeClickable(Data));

		boolean SB2 = Data1.isDisplayed();
		System.out.println(SB2);
		Data1.click();
		//driver.findElement().click();

		//click on browse button
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement BrowseBtn1 = wait3.until(ExpectedConditions.elementToBeClickable(BrowseBtn));

		boolean SB3 = BrowseBtn1.isDisplayed();
		System.out.println(SB3);
		BrowseBtn1.click();
		//driver.findElement().click();


		Thread.sleep(5000);//pause of 5 seconds

		Runtime.getRuntime().exec("C://Users//LENOVO//eclipse-workspace//OrangeHRM//FileUploadOrangeHRM.exe");

		Thread.sleep(5000);

		//click on upload button
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement UploadBtn1 = wait4.until(ExpectedConditions.elementToBeClickable(UploadBtn));

		boolean SB4 = UploadBtn1.isDisplayed();
		System.out.println(SB4);
		UploadBtn1.click();
		//driver.findElement().submit();
		
//		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
//		Alert alert = wait5.until(ExpectedConditions.alertIsPresent());
//		
//		//Alert alert = driver.switchTo().alert(); // switch to alert
//
//		String alertMessage= driver.switchTo().alert().getText(); // capture alert message
//
//		System.out.println(alertMessage); // Print Alert Message
//		Thread.sleep(1000);
//		alert.accept();
		
		
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement Alertmsg1 = wait.until(ExpectedConditions.visibilityOfElementLocated(AlertMsg));
		
		String successMessage = Alertmsg1.getText();
		System.out.println("Upload message: " + successMessage);
		
		WebDriverWait wait6 = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement AlertBtn1 = wait3.until(ExpectedConditions.elementToBeClickable(AlertBtn));
		AlertBtn1.click();
		
		return successMessage;

	}
	

}
