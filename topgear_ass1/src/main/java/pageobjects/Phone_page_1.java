package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Phone_page_1 {
	
public WebDriver driver;
	
	public Phone_page_1(WebDriver driver) {
		this.driver = driver;
	}
	
	By txt = By.xpath("//div[@class=\"tab-content\"] // ul//li[5]");
	
	By add_to_cart = By.cssSelector(".btn.btn-primary.btn-lg.btn-block");
	
	By shopping_cart = By.xpath("//ul[@class=\"list-inline\"] //li[4] // a[@title=\"Shopping Cart\"]");

	public WebElement getTxt() {
		return driver.findElement(txt);
	}

	public WebElement getAdd_to_cart() {
		return driver.findElement(add_to_cart);
	}

	public WebElement getShopping_cart() {
		return driver.findElement(shopping_cart);
	}
	
	

}
