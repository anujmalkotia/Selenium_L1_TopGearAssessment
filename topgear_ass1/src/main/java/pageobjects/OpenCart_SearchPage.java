package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCart_SearchPage {
	
	public WebDriver driver;
	
	public OpenCart_SearchPage(WebDriver driver) {
		this.driver = driver;
	}
	
	By dropdown1 = By.xpath("//select[@class='form-control']");
	
	By chck_box1 = By.xpath("//input[@name=\"sub_category\"]");
	
	By search_btn = By.cssSelector("input[value='Search']");
	
	By PhonePda = By.linkText("Phones & PDAs");

	public WebElement getDropdown1() {
		return driver.findElement(dropdown1);
	}

	public WebElement getChck_box1() {
		return driver.findElement(chck_box1);
	}

	public WebElement getSearch_btn() {
		return driver.findElement(search_btn);
	}

	public WebElement getPhonePda() {
		return driver.findElement(PhonePda);
	}
	
	

}
