package test;

import java.io.IOException;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import base.ProjectSpecificationMethods;
import pages.HomePage;

public class TC_005_PurchaseTest extends ProjectSpecificationMethods {

	@BeforeTest
	public void dataSetup() throws IOException {
		propertyFileTestData();
		testName = "Purchase Functionality";
	    testDescription = "Testing the purchase functionalities"; 
	    testAuthor = "ArunPrasath Mohanraj"; 
	}
	
	@Test
	public void purchaseTest() throws InterruptedException {
		HomePage obj = new HomePage(driver);
		obj.logIn()
		.loginUsername(prop.getProperty("username"))
		.loginPassword(prop.getProperty("password"))
		.loginButton()
		.valiDation()
		.clickPlaceOrder()
		.customerName()
		.customerCountry()
		.customerCity()
		.customerCardNumber()
		.customerMonth()
		.customerYear()
		.clickPurchasebutton()
		.clickOkbutton()
		.logOut();
	}
}