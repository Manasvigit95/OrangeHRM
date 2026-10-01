package com.OrangeHRM.pages;

import java.time.Duration;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OrangeHRM.utils.CommonUtils;

public class SearchEmployeePage {
	
	public WebDriver driver;
	CommonUtils util;
	public Properties prop;
	
	
	public SearchEmployeePage(WebDriver driver) {

		this.driver = driver;
		util = new CommonUtils(driver);

	}
	
	
	private By PIMBtn = By.xpath("//span[text()='PIM']");
	
	private By EL = By.xpath("//a[normalize-space()='Employee List']");
	
	private By EmpName = By.xpath("(//input[@placeholder = 'Type for hints...'])[1]");
	
	private By searchbtn = By.xpath("//button[@type = 'submit']");
	
	private By msg = By.xpath("//span[@class = 'oxd-text oxd-text--span']");
	
	private By EmpID = By.xpath("(//input[@class = 'oxd-input oxd-input--active'])[2]");
	
	private By TableRow = By.xpath("//div[@role = 'row']");
	
	private By TableColumn = By.xpath("((//div[@role='row'])[2]/div[@role='cell'])[2]");
	
	
	public String searchEmployee(Properties prop) {
		
		//click on PIM menu
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
		
		String MSG = util.doGetText(msg);
		
		return MSG;
		
	}
	
	public String searchEmployee1(Properties prop) throws InterruptedException {
		
		//click on PIM menu
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
		
		Thread.sleep(1000);
		
		Li.get(0).sendKeys("ABC");
		
		//click on search button
		WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(1000));
		WebElement searchbtn1 = wait.until(ExpectedConditions.elementToBeClickable(searchbtn));
		
		boolean SB3 = searchbtn1.isDisplayed();
		System.out.println(SB3);
		searchbtn1.click();
		
		String MSG = util.doGetText(msg);
		
		System.out.println(MSG);
		
		return MSG;
		
	}
	
	
	public String searchEmployeeByID(Properties prop) throws InterruptedException {
		
		String MsgActual = null;
		
		//click on PIM menu
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
				
		Thread.sleep(1000);
		
		util.doSendKeys(EmpID, "04591234");
		
		Thread.sleep(1000);
		
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("window.scrollBy(0," + 500 + ")");
		
		Thread.sleep(1000);
		
		List<WebElement> rows = util.getElement(TableRow);
		
		if(rows.size()>1) {
			
			Thread.sleep(1000);
			
			MsgActual = util.doGetText(TableColumn);
			
		}
		
		//System.out.println(MsgActual);	
		
		return MsgActual;
		
	}
	
	

}
