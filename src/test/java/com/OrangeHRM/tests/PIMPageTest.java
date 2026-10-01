package com.OrangeHRM.tests;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import com.OrangeHRM.pages.HomePage;

public class PIMPageTest extends BaseClassTest {
	
	@Test
	public void validateCreateEmployee() throws InterruptedException {
		
		login.login(prop);
		
		String confirmMessage = pimpage.createEmployee(prop);
		
		if(confirmMessage.contains("Personal Details")) {
			
			System.out.println("Employee added successfully");
			
		}
		else {
			
			System.out.println("Failed to add employee");
			
		}
		
		homepage.logOut(prop);
		
	}

}
