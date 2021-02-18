package testcases;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import jdk.internal.net.http.common.Log;
import pageobjects.OpenCart_loignpage;
import pageobjects.OpenCart_homepage;
import pageobjects.inlogin_page;
import resources.base;
import utilities.ReusableComponents;

public class login_test extends base {
	
	public WebDriver driver;
	
	ReusableComponents rc = new ReusableComponents();
	
	@BeforeMethod
	public void beforemethod() throws IOException
	{
		driver = driverSetup();
		driver.get(rc.getProperty("home_url"));
	}
	
	@Test(dataProvider="logindata")
	public void clickonlogin(String username, String passwd, String testcasename) throws IOException
	{
		System.out.println(driver.getTitle());
		
		OpenCart_homepage hp = new OpenCart_homepage(driver);
		hp.getMy_act().click();
		hp.getLogin().click();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Account Login");
		
		OpenCart_loignpage lp = new OpenCart_loignpage(driver);	
		lp.getEmail().sendKeys(username);
		lp.getPasswd().sendKeys(passwd);
		lp.getLogin_btn().click();
		
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "My Account");
		inlogin_page ilp = new inlogin_page(driver);
		ilp.getMy_act1().click();
		ilp.getLogout_btn().click();
		
		
	}
	
	@DataProvider(name="logindata")
	public Object[][] getTestData() throws IOException
	{
		return rc.readDatafromExcel(0);
	}
	
}
