package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCart_product_comp {
public WebDriver driver;
	
	public OpenCart_product_comp(WebDriver driver) {
		this.driver = driver;
	}
	
	By prod1 = By.xpath("//div[@class=\"col-sm-12\"] //tbody//td//a//strong");

	public WebElement getProd1() {
		return driver.findElement(prod1);
	}

}
