package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_001_SignUpTest extends ProjectSpecificationMethods {

	@BeforeTest 
	public void dataSetup() throws IOException { 
		propertyFileTestData();
		testName = "SignUp Functionality";
	    testDescription = "SignUp with valid & invalid credentials"; 
	    testAuthor = "ArunPrasath Mohanraj"; 
	}
	
	@Test
	public void signupTest() throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.signUp()
		.username(prop.getProperty("signname"))
		.passWord(prop.getProperty("signpassword"))
		.signupButton();
	}
}