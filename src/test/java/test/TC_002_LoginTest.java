package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_002_LoginTest extends ProjectSpecificationMethods{

	@BeforeTest()
	public void dataSetup() throws IOException {
		
		testName = "Login Functionality";
	    testDescription = "login with valid & invalid credentials"; 
	    testAuthor = "ArunPrasath Mohanraj"; 
	}
	
	@Test(priority=0)
	public void loginTest() throws InterruptedException, IOException {
		HomePage obj = new HomePage(driver);
		propertyFileTestData();
		obj.logIn()
		.loginUsername(prop.getProperty("username"))
		.loginPassword(prop.getProperty("password"))
		.loginButton()
		.valiDation()
		.logOut();
	}
	
	@Test(priority=1)
	public void invalidLoginTest() throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.logIn()
		.loginUsername(prop.getProperty("invalidusername"))
		.loginPassword(prop.getProperty("invalidpassword"))
		.loginButton()
		.refresh()
		.valiDation()
		.logOut();
	}
}