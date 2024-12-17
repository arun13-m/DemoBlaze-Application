package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_003_ProductTest extends ProjectSpecificationMethods{

	@BeforeTest
	public void dataSetup() throws IOException {
		propertyFileTestData();
		testName = "Product page Functionality";
	    testDescription = "Testing the product page functionalities"; 
	    testAuthor = "ArunPrasath Mohanraj"; 
	}
	
	@Test
	public void productTest() throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.logIn()
		.loginUsername(prop.getProperty("username"))
		.loginPassword(prop.getProperty("password"))
		.loginButton()
		.valiDation()
		.dashBoard()
		.checkingMenu()
		.selectProduct()
		.selectProduct2()
		.openingCart()
		.logOut();
	}
}