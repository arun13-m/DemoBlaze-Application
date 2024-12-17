package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class HomePage extends ProjectSpecificationMethods {

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}
	
	//click signup for registration
	public SignUpPage signUp() {
		ele = driver.findElement(By.linkText("Sign up"));
		Assert.assertTrue(ele.isDisplayed(),"SignUp link is displayed" );
		driver.findElement(By.id("signin2")).click();
		return new SignUpPage(driver);
	}
	
	//click the login link
	public LoginPage logIn() {
		driver.findElement(By.id("login2")).click();
		return new LoginPage(driver);
	}
	
	//click the cart option to perform the cart page functionalities
	public CartPage clickCart() {
		driver.findElement(By.xpath("(//a[contains(@class,'nav-link')])[4]")).click();
		return new CartPage(driver);
	}
	
	public PurchasePage clickPlaceOrder() throws InterruptedException {
		driver.findElement(By.xpath("(//a[contains(@class,'nav-link')])[4]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//button[contains(@class,'btn btn-success')]")).click();
		return new PurchasePage(driver);
	}
	
	public LogOutPage homeValidation() {
		ele = driver.findElement(By.xpath("(//a[contains(@class,'nav-link')])[1]"));
		Assert.assertTrue(ele.isDisplayed());
		return new LogOutPage(driver);
	}
	
	//product page
	public ProductPage dashBoard() {
		ele = driver.findElement(By.xpath("(//a[contains(@class,'nav-link')])[1]"));
		Assert.assertTrue(ele.isDisplayed());
		return new ProductPage(driver);
	}
	//common logout
	public HomePage logOut() {
		driver.findElement(By.xpath("//a[contains(@id,'logout2')]")).click();
		return new HomePage(driver);
	}
}
