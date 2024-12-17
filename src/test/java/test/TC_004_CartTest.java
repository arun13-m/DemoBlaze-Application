package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_004_CartTest extends ProjectSpecificationMethods {
	
	@BeforeTest
	public void dataSetup() throws IOException {
		propertyFileTestData();
		testName = "Cart Functionality";
	    testDescription = "Testing the cart functionalities"; 
	    testAuthor = "ArunPrasath Mohanraj"; 
	}
	
	@Test
	public void cartTest() throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.logIn()
		.loginUsername(prop.getProperty("username"))
		.loginPassword(prop.getProperty("password"))
		.loginButton()
		.valiDation()
		.clickCart()
		.deleteProduct()
		.totalAmount()
		.logOut();
	}
}
