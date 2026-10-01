package com.OrangeHRM.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.OrangeHRM.pages.HomePage;
import com.OrangeHRM.utils.CommonUtils;

public class LoginPageTest extends BaseClassTest {


	@Test(priority = 1)
	public void validateLogoTest() {

		//driver = new WebDriver();
		boolean flag = login.logo();
		System.out.println(flag);
		AssertJUnit.assertTrue(flag);

	}
	
	@Test(priority = 2)
	public void validateLoginWithInvalidCredentials() {
		
		String actualMessage = login.loginInvalidCredentials(prop);
		
		System.out.println(actualMessage);
		
		String expectedMessage = "Invalid credentials";
		
		AssertJUnit.assertEquals(actualMessage, expectedMessage);
		

	}

	@Test(priority = 3)
	public void validateLogin() {

		login.login(prop);
		//homepage = login.login(prop);

		driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);

		String actualURL = driver.getCurrentUrl();

		System.out.println("Actual URL "+actualURL);

		String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";

		AssertJUnit.assertEquals(actualURL, expectedURL);


	}

	@Test(priority = 4)
	public void validateLogOut() throws InterruptedException {

		homepage.logOut(prop);

		String actualURL = driver.getCurrentUrl();

		System.out.println(actualURL);

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.urlToBe("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login"));
		String expectedURL = "https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";

		AssertJUnit.assertEquals(actualURL, expectedURL);


	}
}
