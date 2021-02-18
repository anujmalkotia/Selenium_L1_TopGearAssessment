package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCart_MyAccountPage {
public WebDriver driver;
	
	public OpenCart_MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By search = By.cssSelector("input[name=\"search\"]");
	By search_btn = By.cssSelector(".btn.btn-default.btn-lg");

	public WebElement getSearch() {
		return driver.findElement(search);
	}
	public WebElement getSearch_btn() {
		return driver.findElement(search_btn);
	}
	
	

}
