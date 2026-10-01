package com.OrangeHRM.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.OrangeHRM.base.BaseClass;
import com.OrangeHRM.pages.FileUploadPage;
import com.OrangeHRM.pages.HomePage;
import com.OrangeHRM.pages.LoginPage;
import com.OrangeHRM.pages.PIMPage;
import com.OrangeHRM.pages.SearchEmployeePage;
import com.OrangeHRM.pages.EmplyoeeImage;
import com.OrangeHRM.pages.ApplyLeave;
import com.OrangeHRM.pages.DeleteEmployee;
import com.OrangeHRM.pages.PrintEmployeeList;


public class BaseClassTest {

	public WebDriver driver;
	public Properties prop;

	BaseClass basec;

	LoginPage login;

	HomePage homepage;
	
	PIMPage pimpage;
	
	SearchEmployeePage searchemp;
	
	FileUploadPage fileuploadpage;
	
	EmplyoeeImage employeeimage;
	
	DeleteEmployee deleteemployee;
	
	PrintEmployeeList printemployeelist;
	
	ApplyLeave applyleave;


	@BeforeMethod
	@BeforeTest
	public void setUp() throws IOException {

		basec = new BaseClass();
		prop = basec.init_prop();
		driver = basec.init_driver(prop);
		login = new LoginPage(driver);
		homepage = new HomePage(driver);
		pimpage = new PIMPage(driver);
		searchemp = new SearchEmployeePage(driver);
		fileuploadpage = new FileUploadPage(driver);
		employeeimage = new EmplyoeeImage(driver);
		deleteemployee = new DeleteEmployee(driver);
		printemployeelist = new PrintEmployeeList(driver);
		applyleave = new ApplyLeave(driver);

	}

	@AfterMethod
	@AfterTest
	public void tearDown() {

		driver.quit();

	}


}
