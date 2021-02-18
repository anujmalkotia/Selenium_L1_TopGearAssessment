package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCart_loignpage {
	
	public WebDriver driver;
	
	By email = By.xpath("//input[@placeholder=\"E-Mail Address\"]");
	By passwd = By.xpath("//input[@placeholder=\"Password\"]");
	By login_btn = By.xpath("//input[@class=\"btn btn-primary\"]");
	
	
	//constructor for Webdriver
		public OpenCart_loignpage(WebDriver driver) {
			this.driver = driver;
		}

		public WebElement getEmail() {
			return driver.findElement(email);
		}

		public WebElement getPasswd() {
			return driver.findElement(passwd);
		}

		public WebElement getLogin_btn() {
			return driver.findElement(login_btn);
		}
	
	

}
