package com.OrangeHRM.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OrangeHRM.utils.CommonUtils;

public class DeleteEmployee {
	
	public WebDriver driver;
	CommonUtils util;
	public Properties prop;
	
	private By PIMBtn = By.xpath("//span[text()='PIM']");
	private By EL = By.xpath("//a[normalize-space()='Employee List']");
	private By EmpName = By.xpath("(//input[@placeholder = 'Type for hints...'])[1]");
	private By searchbtn = By.xpath("//button[@type = 'submit']");
	private By deletebtn = By.xpath("//i[@class='oxd-icon bi-trash']");
	private By yesbtn = By.xpath("//i[@class='oxd-icon bi-trash oxd-button-icon']");
	private By msg = By.xpath("//span[@class = 'oxd-text oxd-text--span']");
	
	
	public DeleteEmployee (WebDriver driver) {
		
		this.driver = driver;
		util = new CommonUtils(driver);
		
	}
	
	public String deleteEmployee(Properties prop) throws IOException, InterruptedException {	

		//find PIM Menu and click on PIM Menu
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement PIMBtn1 = wait.until(ExpectedConditions.elementToBeClickable(PIMBtn));
		
		boolean SB = PIMBtn1.isDisplayed();
		System.out.println(SB);
		PIMBtn1.click();

		//select employee list menu
		WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement EL1 = wait.until(ExpectedConditions.elementToBeClickable(EL));
		
		boolean SB1 = EL1.isDisplayed();
		System.out.println(SB1);
		EL1.click();
		
		List<WebElement> Li = util.getElement(EmpName);
		
		System.out.println(Li);
		//div[@class='oxd-autocomplete-text-input oxd-autocomplete-text-input--focus']//input[@placeholder='Type for hints...']
		Li.get(0).sendKeys("Lalita");
		
		//click on search button
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(1000));
		WebElement searchbtn1 = wait.until(ExpectedConditions.elementToBeClickable(searchbtn));
		
		boolean SB3 = searchbtn1.isDisplayed();
		System.out.println(SB3);
		searchbtn1.click();
		
		Thread.sleep(3000);
		
		//Delete the employee
		WebDriverWait wait4 = new WebDriverWait(driver, Duration.ofSeconds(1000));
		WebElement deletebtn1 = wait.until(ExpectedConditions.elementToBeClickable(deletebtn));
		
		boolean DB = deletebtn1.isDisplayed();
		System.out.println(DB);
		deletebtn1.click();
		
		//Click yes on delete message 
		WebDriverWait wait5 = new WebDriverWait(driver, Duration.ofSeconds(1000));
		WebElement yesbtn1 = wait.until(ExpectedConditions.elementToBeClickable(yesbtn));
		
		boolean YB = deletebtn1.isDisplayed();
		System.out.println(YB);
		yesbtn1.click();
		
		String MSG = util.doGetText(msg);
		
		System.out.println(MSG);
		
		return MSG;
		
		

	}
	
//	public void searchEmployee() {
//		
//		
//	}

}
