package utility;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.HomePage;

public class Utilities {

	public static WebDriver driver;
	public static WebElement ele;
	public static String expectedResult;
	public static String actualResult;
	public static Properties prop;
	public static ExtentReports report;
	public static ExtentTest test;
	public String testName, testDescription, testAuthor;
	
	//launch the browser and url
	public void browserAndURL(String browser) {
		 if(browser.equals("chrome")) {
			 driver = new ChromeDriver();
		 }
		 else if(browser.equals("edge")) {
				driver = new EdgeDriver();
			} 
		 driver.get("https://www.demoblaze.com/");
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	 }
	
	 //closing the browser
	 public void browserClose() {
		 driver.close();
	 }
	 
	 //sendKeysMethod
	 public void sendKeysMethod(WebElement ele, String input) {
		 ele.sendKeys(input);
	 }
	 
	 //property file reading method
	 public static void propertyFileTestData() throws IOException {
		 FileReader file = new FileReader("C:\\Users\\arunp\\eclipse-workspace\\Demoblaze\\src\\test\\resources\\TestData\\Data.properties");
		 prop = new Properties();
		 prop.load(file);
	 }
	 
	 //creating the report in the location
	 public void reptInitilization() {
		 String path = "C:\\Users\\arunp\\eclipse-workspace\\Demoblaze\\Reports\\DemoBlaze-Report\\DemoBlaze_Application.html";
		 //to crate a report in given location
		 ExtentSparkReporter reporter = new ExtentSparkReporter(path); 
		 reporter.config().setReportName("DemoBlaze Application");
			
		 //to capture the data
		 report = new ExtentReports();
	     report.attachReporter(reporter);
	 }
	 
	 //Giving the test details
	 public void tDetails() {
		 test = report.createTest(testName, testDescription);
		 test.assignAuthor(testAuthor);
	 }
	 
	 //screenshot method for failed testcase 
	 public String screenShot(String name)throws IOException { 
		 String path = "C:\\Users\\arunp\\eclipse-workspace\\Demoblaze\\ScreenShot\\"+name+".png"; 
		 File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE); 
		 File dest = new File(path); FileUtils.copyFile(src, dest);
		 return path;
	 }
	 
	 //common logout
	 public HomePage logOut() {
		 driver.findElement(By.xpath("//a[contains(@id,'logout2')]")).click();
		 return new HomePage(driver);
	 } 
	 
}