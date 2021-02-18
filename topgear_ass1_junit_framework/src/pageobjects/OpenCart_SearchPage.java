package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCart_SearchPage {
public WebDriver driver;
	
	public OpenCart_SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By img = By.cssSelector(".img-responsive");

	public WebElement getImg() {
		return driver.findElement(img);
	}
	
	

}
