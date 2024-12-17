package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.ProjectSpecificationMethods;

public class PurchasePage extends ProjectSpecificationMethods {

	public PurchasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="name")
	WebElement name;
	
	@FindBy(id="country")
	WebElement country;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="card")
	WebElement cCard ;
	
	@FindBy(id="month")
	WebElement month ;
	
	@FindBy(id="year")
	WebElement year ;
	
	@FindBy(xpath="(//button[contains(@class,'btn btn-primary')])[3]")
	WebElement purchase;
	
	@FindBy(xpath="//button[contains(@class,'confirm btn btn-lg btn-primary')]")
	WebElement okButton;
	
	//name
	public PurchasePage customerName() {
		name.sendKeys("Arun M");
		return this;
	}
	
	//country
	public PurchasePage customerCountry() {
		country.sendKeys("India");
		return this;
	}
	
	//City
	public PurchasePage customerCity() {
		city.sendKeys("Chennai");
		return this;
	}
	
	//Card
	public PurchasePage customerCardNumber() {
		cCard.sendKeys("4242424242424242");
		return this;
	}
	
	//Month
	public PurchasePage customerMonth() {
		month.sendKeys("Dec");
		return this;
	}
	
	//Year
	public PurchasePage customerYear() throws InterruptedException {
		year.sendKeys("2024");
		Thread.sleep(2000);
		return this;
	}
	
	//click the purchase button
	public PurchasePage clickPurchasebutton() throws InterruptedException {
		purchase.click();
		Thread.sleep(5000);
		return this;
	}
	
	//click ok button after the purchase completed
	public HomePage clickOkbutton() {
		okButton.click();
		return new HomePage(driver);
	}
}
