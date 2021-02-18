package test_cases;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageobjects.OpenCart_LoginPage;
import pageobjects.OpenCart_MyAccountPage;
import pageobjects.OpenCart_SearchPage;
import pageobjects.OpenCart_SearchResultPage;
import pageobjects.OpenCart_homepage;
import resources.base;
import utilities.ReusableComponents;

public class junit_framework extends base {
	
public WebDriver driver;
	
	ReusableComponents rc = new ReusableComponents();
	
	@Before
	public void beforemethod() throws IOException
	{
		driver = driverSetup();
		driver.get(rc.getProperty("home_url"));
		driver.manage().window().maximize();
	}
	
	@Test
	public void user_login() 
	{
		OpenCart_homepage hp = new OpenCart_homepage(driver);
		hp.getMy_act().click();
		hp.getLogin().click();
		
		
		String title = driver.getTitle();
		Assert.assertEquals(title, "Account Login");
		OpenCart_LoginPage lp = new OpenCart_LoginPage(driver);
		lp.getEmail().sendKeys("ericleshner03@gmail.com");
		lp.getPsswd().sendKeys("eric123456");
		lp.getLogin_btn().click();
		
		
		String title1 = driver.getTitle();
		Assert.assertEquals(title1, "My Account");
		OpenCart_MyAccountPage map = new OpenCart_MyAccountPage(driver);
		String search_opt = "canon";
		map.getSearch().sendKeys(search_opt);
		map.getSearch_btn().click();
		
		String title2 = driver.getTitle();
		Assert.assertEquals(title2, "Search - " + search_opt );
		OpenCart_SearchPage sp = new OpenCart_SearchPage(driver);
		sp.getImg().click();
		
		String title3 = driver.getTitle();
		Assert.assertEquals(title3, "sdf");
		OpenCart_SearchResultPage srp = new OpenCart_SearchResultPage(driver);
		srp.getQuantity().sendKeys("3");
		srp.getAddtocart().click();
		WebDriverWait wait=new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.attributeContains(srp.getAlert(), "Select required!", srp.getAlert().getText()));
		
		if(srp.getAlert().isEnabled()) {
			Assert.assertFalse(true);
		}
	
		
	}

}
