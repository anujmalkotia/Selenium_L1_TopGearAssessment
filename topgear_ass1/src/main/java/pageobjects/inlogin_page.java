package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class inlogin_page {
	
	public WebDriver driver;
	
	By logout_btn = By.linkText("Logout");
	By my_act1 = By.xpath("//a[@title=\"My Account\"]");
	By search_box = By.cssSelector("input[name='search']");

	public inlogin_page(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
	}

	public WebElement getLogout_btn() {
		return driver.findElement(logout_btn);
	}

	public WebElement getMy_act1() {
		return driver.findElement(my_act1);
	}

	public WebElement getSearch_box() {
		return driver.findElement(search_box);
	}
}
