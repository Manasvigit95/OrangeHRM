package com.OrangeHRM.tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.OrangeHRM.pages.HomePage;
import com.OrangeHRM.pages.PrintEmployeeList;

public class PrintEmployeeListTest extends BaseClassTest {
	
@Test
	
	public void validateEmployeeList() throws InterruptedException, IOException {
		
		login.login(prop);
		
		 List<String> names = printemployeelist.printEmployeeList(prop);
		    
		 // Assertion 1: Check that the list is NOT empty
		 Assert.assertTrue(names.size() > 0, "The employee list is empty!");
		    
		 // Assertion 2: Check if a specific employee exists in the list
		 Assert.assertTrue(names.contains("Smith"), "Employee 'Smith' was not found in the list!");
		
		
		Thread.sleep(5000);
		
		homepage.logOut(prop);
		

}
}
