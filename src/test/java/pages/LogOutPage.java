package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class LogOutPage extends ProjectSpecificationMethods {

	public LogOutPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[contains(@onclick,'logOut()')]")
	WebElement logoutValid;
	
	//validating the logout button is enabled or not
	public HomePage logoutValidation() {
		Assert.assertTrue(logoutValid.isEnabled(), "Logout button is enabled");
		return new HomePage(driver);
	}
	
}