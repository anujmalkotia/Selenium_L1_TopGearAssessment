package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCart_homepage {
	
	public WebDriver driver;
	
	public OpenCart_homepage(WebDriver driver) {
		this.driver = driver;
	}

	
	By my_act = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a");
	By login = By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[2]/a");
	
	public WebElement getMy_act() {
		return driver.findElement(my_act);
	}
	public WebElement getLogin() {
		return driver.findElement(login);
	}
	
}
