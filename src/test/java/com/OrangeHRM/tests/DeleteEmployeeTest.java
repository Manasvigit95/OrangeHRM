package com.OrangeHRM.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.OrangeHRM.pages.HomePage;

public class DeleteEmployeeTest extends BaseClassTest {
	
@Test
	
	public void validateDeleteEmployee() throws InterruptedException, IOException {
		
		login.login(prop);
		
		String expectedMessage = "No Records Found";
		
		String actualMessage = deleteemployee.deleteEmployee(prop);
		
		System.out.println(actualMessage);
		
		String result = actualMessage.replaceAll("\\(\\d+\\)", "").trim();
        System.out.println(result);
		
		AssertJUnit.assertTrue(result.contains(expectedMessage));
		
		Thread.sleep(5000);
		
		homepage.logOut(prop);
		
		
	}

}
