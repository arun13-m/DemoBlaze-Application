package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import base.ProjectSpecificationMethods;

public class LoginPage extends ProjectSpecificationMethods {

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="(//input[contains(@class,'form-control')])[5]")
	WebElement lUser; 
	
	@FindBy(id="loginpassword")
	WebElement lPword;
	
	@FindBy(xpath="//button[contains(@onclick,'logIn()')]")
	WebElement loginButton; 
	
	@FindBy(xpath="//a[contains(@id,'logout2')]")
	WebElement logout;
	
	@FindBy(id="nameofuser")
	WebElement valid;
	
	//username for login
	public LoginPage loginUsername(String loginName) {
		sendKeysMethod(lUser, loginName);
		return this;
	}
	
	//password for login
	public LoginPage loginPassword(String passWord) {
		sendKeysMethod(lPword, passWord);
		return this;
	}
	
	//click for successful login
	public LoginPage loginButton() throws InterruptedException {
		ele = driver.findElement(By.xpath("//button[contains(@onclick,'logIn()')]"));
		Assert.assertTrue(ele.isEnabled(),"login button is enabled");
		Thread.sleep(2000);
		loginButton.click();
		
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
		return this;
	}
	
	//refresh method
	public LoginPage refresh() {
		driver.navigate().refresh();
		return this;
	}
	
	//validation for successful login
	public HomePage valiDation() {
		ele = driver.findElement(By.xpath("//a[contains(text(),'Welcome arunmtest1')]"));
		Assert.assertTrue(ele.isDisplayed());
		return new HomePage(driver);
	}
}