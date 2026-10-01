package com.OrangeHRM.pages;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.ArrayList; 

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OrangeHRM.utils.CommonUtils;

public class PrintEmployeeList {
	
	public WebDriver driver;
	CommonUtils util;
	public Properties prop;
	
	private By PIMBtn = By.xpath("//span[text()='PIM']");
	private By EL = By.xpath("//a[normalize-space()='Employee List']");
	private By totalLinks = By.xpath("//ul[@class='oxd-pagination__ul']/li");
	private By element = By.xpath("//div[@class = 'oxd-table-card']/div/div[4]");
	
	
	
	public PrintEmployeeList (WebDriver driver) {
		
		this.driver = driver;
		util = new CommonUtils(driver);
		
	}
	
	public List<String> printEmployeeList(Properties prop) throws IOException, InterruptedException {	

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
		
		//print the list
		List<WebElement> LiEle = util.getElement(totalLinks);
		
		int totalLinks = LiEle.size();
		
		System.out.println(totalLinks);
		
		List<String> collectedNames = new ArrayList<>();
		
		for(int i = 0; i<totalLinks;i++) {    //0,1,2,3,4
			
			
			try {
				
				String currentLinkText = LiEle.get(i).getText(); 	
				
				int page = Integer.parseInt(currentLinkText);
				
				System.out.println("Page: " + page);
								
				LiEle.get(i).click();
				
				Thread.sleep(2000);
				
				List<WebElement> empList = util.getElement(element);
				
				for(int i1=0;i1<empList.size();i1++) {
					
					//print last name of each row
					String lastName = empList.get(i1).getText();
					System.out.println(lastName);
					
					collectedNames.add(lastName);
				}
				
			}
			catch(Exception e) {
				
				System.out.println("Not a Number.");
			}
			
			}
		return collectedNames;
		}
			

}
