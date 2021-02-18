package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCart_Shopping_Page {
public WebDriver driver;
	
	public OpenCart_Shopping_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	By chckout = By.xpath("//a[@class=\"btn btn-primary\"]");
	By alert_msg = By.cssSelector(".alert.alert-danger.alert-dismissible");
	
	

	public WebElement getChckout() {
		return driver.findElement(chckout);
	}



	public WebElement getAlert_msg() {
		return driver.findElement(alert_msg);
	}
	
	

}
