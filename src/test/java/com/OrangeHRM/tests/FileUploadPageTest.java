package com.OrangeHRM.tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.Alert;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.WebDriverWait;

import com.OrangeHRM.pages.FileUploadPage;
import com.OrangeHRM.pages.HomePage;

public class FileUploadPageTest extends BaseClassTest{

	@Test
	
	public void validateFileUpload() throws InterruptedException, IOException {
		
		login.login(prop);
		
		
		String alertMessage = null;
		
		try {
			alertMessage = fileuploadpage.fileUpload(prop);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(alertMessage.contains("1 record Successfully Imported")) {
			
			System.out.println("Data present inside the file and added successfully ");
			
		}
		else {
			
			System.out.println("No record imported");
			
		}
		
		
		homepage.logOut(prop);
		
	}

}
