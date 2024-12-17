package base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import utility.Utilities;

public class ProjectSpecificationMethods extends Utilities{

//launch the browser and url
	@Parameters({"browser"})
	@BeforeMethod
	public void launchBrowserAndURL(String browser){
		browserAndURL(browser);
	}
	
	@BeforeSuite
	public void reportInitialization() {
		reptInitilization();
	}
	
	@AfterSuite
	public void closeReport() {
		report.flush();
	}
	
	@BeforeClass
	public void testDetails() {
		tDetails();
	}
	
	//closing the browser
	@AfterMethod
	public void closeBrowser() {
		browserClose();
	}
}