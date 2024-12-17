package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class SignUpPage extends ProjectSpecificationMethods {
	
	
	@FindBy(id="sign-username")
	WebElement user;
	
	@FindBy(id="sign-password")
	WebElement pWord;
	
	@FindBy(xpath="//button[contains(@onclick,'register()')]")
	WebElement clickSignup;
	
	public SignUpPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//username String userId
	public SignUpPage username(String uName) {
		sendKeysMethod(user, uName);
	   return this;
	}
	
	//password String pass
	public SignUpPage passWord(String sPass) {
		sendKeysMethod(pWord, sPass);
		return this;
	}
	
	//click the signUp button
	public HomePage signupButton() throws InterruptedException {
		ele = driver.findElement(By.xpath("//button[contains(@onclick,'register()')]"));
		Assert.assertTrue(ele.isEnabled(), "Signup button is enabled");
		Thread.sleep(3000);
		clickSignup.click();
		Thread.sleep(3000);
		driver.navigate().refresh();
		return new HomePage(driver);
	}
}