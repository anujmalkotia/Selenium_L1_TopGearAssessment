package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OpenCart_Phone_pda {
	
public WebDriver driver;
	
	public OpenCart_Phone_pda(WebDriver driver) {
		this.driver = driver;
	}
	
	By sort_by = By.cssSelector("#input-sort");
	
	By add_t_c_1 = By.xpath("//button[@onclick=\"compare.add('29');\"]");
	
	By add_t_c_2 = By.xpath("//button[@onclick=\"compare.add('40');\"]");
	
	By add_t_c_3 = By.xpath("//button[@onclick=\"compare.add('28');\"]");
	
	By compare = By.cssSelector("#compare-total");
	
	
	public WebElement getSort_by() {
		return driver.findElement(sort_by);
	}

	public WebElement getAdd_t_c_1() {
		return driver.findElement(add_t_c_1);
	}

	public WebElement getAdd_t_c_2() {
		return driver.findElement(add_t_c_2);
	}

	public WebElement getAdd_t_c_3() {
		return driver.findElement(add_t_c_3);
	}

	public WebElement getCompare() {
		return driver.findElement(compare);
	}
	

}
