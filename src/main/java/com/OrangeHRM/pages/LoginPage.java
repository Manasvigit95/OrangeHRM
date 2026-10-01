package com.OrangeHRM.pages;

import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.OrangeHRM.utils.CommonUtils;

public class LoginPage {

	public WebDriver driver;
	CommonUtils util;
	public Properties prop;

	//This is a constructor use to distinguish between local and global driver
	//variable. when we create the object of this class this constructor gets called up
	//in other classes. This constructor will initialize the class object. 
	public LoginPage(WebDriver driver) {  

		this.driver = driver;
		util = new CommonUtils(driver);
		//prop = new Properties();
	}

	private By username = By.name("username");
	private By password = By.name("password");
	private By submitBtn = (By.xpath("//button[normalize-space()='Login']"));
	private By logo = By.xpath( "//div[@class='orangehrm-login-branding']");
	private By loginError = By.xpath("//p[@class = 'oxd-text oxd-text--p oxd-alert-content-text']");

	public boolean logo() {

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		util.isDisplayed(logo);

		return true;

	}

	public HomePage login(Properties prop) {

		//prop = new Properties();
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(100));
		WebElement submitBtn1 = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[normalize-space()='Login']")));
		submitBtn1.click();
		
		boolean SB = submitBtn1.isDisplayed();
		System.out.println("Button Displayed "+SB);
		
		String U1 = prop.getProperty("UserName");
		String P1 = prop.getProperty("PWD");
		System.out.println("Input value: " + U1);
		System.out.println("Input value: " + P1);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		util.doSendKeys(username, U1);
		util.doSendKeys(password, P1);

		return new HomePage(driver);
	}

	public String loginInvalidCredentials(Properties prop) {
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement submitBtn1 = wait.until(ExpectedConditions.elementToBeClickable(submitBtn));

		boolean SB = submitBtn1.isDisplayed();
		System.out.println(SB);
		submitBtn1.click();
		String U1 = prop.getProperty("UserName");
		String P1 = prop.getProperty("InvalidPWD");
		System.out.println("Input value: " + U1);
		System.out.println("Input value: " + P1);
		util.doSendKeys(username, U1);
		util.doSendKeys(password, P1);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		String actualMessage = util.doGetText(loginError);
		
		return actualMessage;

	}

}
