package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_006_LogoutTest extends ProjectSpecificationMethods {

	@BeforeTest
	public void dataSetup() throws IOException {
		propertyFileTestData();
		testName = "Logout Functionality";
	    testDescription = "Testing the logout functionalities"; 
	    testAuthor = "ArunPrasath Mohanraj"; 
	}
	
	@Test
	public void logoutTest() throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.logIn()
		.loginUsername(prop.getProperty("username"))
		.loginPassword(prop.getProperty("password"))
		.loginButton()
		.valiDation()
		.homeValidation()
		.logoutValidation()
		.logOut(); 
	}
}