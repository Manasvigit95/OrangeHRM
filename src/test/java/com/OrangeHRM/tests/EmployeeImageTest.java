package com.OrangeHRM.tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.testng.annotations.Test;
import org.openqa.selenium.Alert;

import org.openqa.selenium.support.ui.WebDriverWait;

//import com.OrangeHRM.pages.EmplyoeeImage;
import com.OrangeHRM.pages.HomePage;

public class EmployeeImageTest extends BaseClassTest {
	
@Test
	
	public void validateImageUpload() throws InterruptedException, IOException {
		
		login.login(prop);
		
		
		String confirmMessage = employeeimage.emplyoeeImage(prop);
		
		if(confirmMessage.contains("Personal Details")) {
			
			System.out.println("Employee added successfully");
			
		}
		else {
			
			System.out.println("Failed to add employee");
			
		}
		
		homepage.logOut(prop);
		
	}


}
