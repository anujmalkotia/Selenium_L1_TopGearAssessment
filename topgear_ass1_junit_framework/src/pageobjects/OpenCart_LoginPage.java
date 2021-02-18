package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCart_LoginPage {
public WebDriver driver;
	
	public OpenCart_LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By email = By.cssSelector("#input-email");
	By psswd = By.cssSelector("#input-password");
	By login_btn = By.xpath("//input[@value='Login']");

	public WebElement getEmail() {
		return driver.findElement(email);
	}
	public WebElement getPsswd() {
		return driver.findElement(psswd);
	}
	public WebElement getLogin_btn() {
		return driver.findElement(login_btn);
	}
	
	

}
