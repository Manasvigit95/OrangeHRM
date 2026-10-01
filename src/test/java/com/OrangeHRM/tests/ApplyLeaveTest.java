package com.OrangeHRM.tests;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

public class ApplyLeaveTest extends BaseClassTest{
	
@Test
	
	public void validateApplyLeave() throws InterruptedException, IOException {
		
		login.login(prop);
		
        String expectedMessage = "Records Found";
		
		String actualMessage = applyleave.applyLeave(prop);
		
		System.out.println(actualMessage);
		
		String result = actualMessage.replaceAll("\\(\\d+\\)", "").trim();
        System.out.println(result);
		
		AssertJUnit.assertTrue(result.contains(expectedMessage));
		
		Thread.sleep(5000);
		
		homepage.logOut(prop);
		

}

}
