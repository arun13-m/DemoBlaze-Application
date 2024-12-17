package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class ProductPage extends ProjectSpecificationMethods {

	public ProductPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="(//a[contains(@class,'nav-link')])[1]")
	WebElement home;
	
	@FindBy(xpath="(//a[contains(@class,'nav-link')])[2]")
	WebElement contact;
	
	@FindBy(xpath="(//a[contains(@class,'nav-link')])[3]")
	WebElement aboutus;
	
	@FindBy(xpath="(//a[contains(@class,'list-group-item')])[2]")
	WebElement phones;
	
	@FindBy(xpath="(//a[contains(@class,'list-group-item')])[3]")
	WebElement laptops;
	
	@FindBy(xpath="(//a[contains(@class,'list-group-item')])[4]")
	WebElement monitors;
	
	@FindBy(xpath="//a[contains(text(),'Samsung galaxy s6')]")
	WebElement product;
	
	@FindBy(xpath="//a[contains(text(),'MacBook air')]")
	WebElement product2;
	
	@FindBy(linkText="Cart")
	WebElement cart;
	
	//chechking the menu items
	public ProductPage checkingMenu() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		Assert.assertTrue(home.isDisplayed(), "Home option is displayed");
		Assert.assertTrue(contact.isDisplayed(), "Home option is displayed");
		Assert.assertTrue(aboutus.isDisplayed(), "Home option is displayed");
		Assert.assertTrue(phones.isDisplayed(), "Home option is displayed");
		Assert.assertTrue(laptops.isDisplayed(), "Home option is displayed");
		Assert.assertTrue(monitors.isDisplayed(), "Home option is displayed");
		return this;
	}
	
	//select the product and added to the cart
	public ProductPage selectProduct() throws InterruptedException {
		Thread.sleep(2000);
		product.click();
		//add the product to the cart
		driver.findElement(By.xpath("//a[contains(@class,'btn btn-success btn-lg')]")).click();
		driver.navigate().back();
		driver.navigate().back();
		return this;
	}
	
	//select the another product and added to the cart
	public ProductPage selectProduct2() throws InterruptedException {
		Thread.sleep(2000);
		laptops.click();
		product2.click();
		//add the product to the cart
		driver.findElement(By.xpath("//a[contains(@class,'btn btn-success btn-lg')]")).click();
		driver.navigate().back();
		driver.navigate().back();
		return this;
	}
	
    //opening the cart
    public HomePage openingCart() throws InterruptedException {
    	Thread.sleep(2000);
    	cart.click();
    	expectedResult = "Samsung galaxy s6";
    	actualResult = driver.findElement(By.xpath("//td[contains(text(),'Samsung galaxy s6')]")).getText();
    	Assert.assertEquals(actualResult, expectedResult);
    	
    	String expectedResult2 = "MacBook air";
    	String actualResult2 = driver.findElement(By.xpath("//td[contains(text(),'MacBook air')]")).getText();
    	Assert.assertEquals(actualResult2, expectedResult2);
    	return new HomePage(driver);
    	
    }
	
}