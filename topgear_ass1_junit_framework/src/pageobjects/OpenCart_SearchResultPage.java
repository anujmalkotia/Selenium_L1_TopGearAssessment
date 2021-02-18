package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCart_SearchResultPage {
	
	public WebDriver driver;

	public OpenCart_SearchResultPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By quantity = By.cssSelector("#input-quantity");
	By addtocart = By.cssSelector(".btn.btn-primary.btn-lg.btn-block");
	By alert = By.cssSelector(".form-group.required.has-error .text-danger");

	public WebElement getQuantity() {
		return driver.findElement(quantity);
	}

	public WebElement getAddtocart() {
		return driver.findElement(addtocart);
	}

	public WebElement getAlert() {
		return driver.findElement(alert);
	}
	
	
}
