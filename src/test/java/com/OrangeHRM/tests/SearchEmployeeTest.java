package com.OrangeHRM.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import com.OrangeHRM.pages.HomePage;
import com.OrangeHRM.utils.CommonUtils;

public class SearchEmployeeTest extends BaseClassTest {
	
	@Test(priority = 1, enabled = true)
	public void validateSearchEmployeeIsPresent() throws InterruptedException {
		
		login.login(prop);
		
		String expectedMessage = "Records Found";
		
		String actualMessage = searchemp.searchEmployee(prop);
		
		System.out.println(actualMessage);
		
		String result = actualMessage.replaceAll("\\(\\d+\\)", "").trim();
        System.out.println(result);
		
		homepage.logOut(prop);
		
		AssertJUnit.assertTrue(result.contains(expectedMessage));
		
	}
	
	@Test(priority = 2, enabled = true)
	public void validateSearchEmployeeIsNotPresent() throws InterruptedException {
		
		login.login(prop);
		
		String expectedMessage = "No Records Found";
		
		Thread.sleep(1000);
		
		String actualMessage = searchemp.searchEmployee1(prop);
		
		Thread.sleep(1000);
		
		System.out.println(actualMessage);
		
		Thread.sleep(1000);
		
		homepage.logOut(prop);
		
		AssertJUnit.assertTrue(actualMessage.contains(expectedMessage));
		
	}

	
	@Test(priority = 3)
	public void validateSearchEmployeeByID() throws InterruptedException {
		
		login.login(prop);
		
		String empID = "04591234";
		
		Thread.sleep(1000);
		
		String actualMessage = searchemp.searchEmployeeByID(prop);
		
		Thread.sleep(1000);
		
		System.out.println(actualMessage);
		
		Thread.sleep(1000);
		
		homepage.logOut(prop);
		
		AssertJUnit.assertEquals(empID, actualMessage);
		
		
	}
}
