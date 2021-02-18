package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCart_homepage {
	
	public WebDriver driver;
	
	By my_act = By.xpath("//a[@title=\"My Account\"]");
	By login = By.linkText("Login");
	By logout = By.linkText("Logout");
	
	
	//constructor for Webdriver
	public OpenCart_homepage(WebDriver driver) {
		this.driver = driver;
	}


	public WebElement getMy_act() {
		return driver.findElement(my_act);
	}


	public WebElement getLogin() {
		return driver.findElement(login);
	}


	public WebElement getLogout() {
		return driver.findElement(logout);
	}

	
}
