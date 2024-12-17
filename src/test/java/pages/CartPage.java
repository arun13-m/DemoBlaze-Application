package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import base.ProjectSpecificationMethods;

public class CartPage extends ProjectSpecificationMethods {

	public CartPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "/html/body/div[6]/div/div[1]/div/table/tbody/tr[1]/td[4]/a")
	WebElement delete;

	@FindBy(css = "#tbodyid > tr > td:nth-child(4) > a")
	WebElement delete2;

	@FindBy(id = "totalp")
	WebElement total;

	// delete the product
	public CartPage deleteProduct() throws InterruptedException {
		Thread.sleep(5000);
		expectedResult = "Samsung galaxy s6";
		actualResult = driver.findElement(By.xpath("//td[contains(text(),'Samsung galaxy s6')]")).getText();
		String expectedResult2 = "MacBook air";
		String actualResult2 = driver.findElement(By.xpath("//td[contains(text(),'MacBook air')]")).getText();
		if (expectedResult.equals(actualResult)) {
			delete.click();
			Thread.sleep(6000);
			
		} else if (expectedResult2.equals(actualResult2)) {
			delete2.click();
			Thread.sleep(6000);
		}
		return this;
	}

	
	// verify the toatl amount after deletion of the product
	public HomePage totalAmount() throws InterruptedException {
		expectedResult = "360";
		actualResult = total.getText();
		if (expectedResult.equals(actualResult)) {
			Assert.assertEquals(actualResult, expectedResult);
		} else {
			expectedResult = "700";
			actualResult = total.getText();
			Assert.assertEquals(actualResult, expectedResult);
		}
		Thread.sleep(5000);
		return new HomePage(driver);
	}
}