package testcases;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageobjects.OpenCart_Phone_pda;
import pageobjects.OpenCart_SearchPage;
import pageobjects.OpenCart_Shopping_Page;
import pageobjects.OpenCart_homepage;
import pageobjects.OpenCart_loignpage;
import pageobjects.OpenCart_product_comp;
import pageobjects.Phone_page_1;
import pageobjects.inlogin_page;
import resources.base;
import utilities.ReusableComponents;

public class selenium_webdriver_testcase extends base{
	
public WebDriver driver;
	
	ReusableComponents rc = new ReusableComponents();
	
	@BeforeClass
	public void beforemethod() throws IOException
	{
		driver = driverSetup();
		driver.get(rc.getProperty("home_url"));
		driver.manage().window().maximize();
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
		ilp.getSearch_box().sendKeys(Keys.ENTER);
		
		String title2= driver.getTitle();
		Assert.assertEquals(title2,"Search");
		OpenCart_SearchPage isp = new OpenCart_SearchPage(driver);
		Select dropdown1 = new Select(isp.getDropdown1());
		dropdown1.selectByValue("28");
		isp.getChck_box1().click();
		isp.getSearch_btn().click();
		
		String title3 = driver.getTitle();
		Assert.assertEquals(title3,"Search");
		isp.getPhonePda().click();
		
		String title4 = driver.getTitle();
		Assert.assertEquals(title4,"Phones & PDAs");
		OpenCart_Phone_pda ippp = new OpenCart_Phone_pda(driver);
		Select dropdown2 = new Select(ippp.getSort_by());
		dropdown2.selectByVisibleText("Price (High > Low)");
		
		String title5 = driver.getTitle();
		Assert.assertEquals(title5,"Phones & PDAs");
		ippp.getAdd_t_c_1().click();
		ippp.getAdd_t_c_2().click();
		ippp.getAdd_t_c_3().click();
		System.out.println("Success");
		
		ippp.getCompare().click();
		
		String title6 = driver.getTitle();
		Assert.assertEquals(title6,"Product Comparison");
		OpenCart_product_comp pc = new OpenCart_product_comp(driver);
		pc.getProd1().click();
		
		Phone_page_1 pp1 = new Phone_page_1(driver);
		String Flat_File = "./src\\main\\java\\resources\\temp.txt";
		File FC = new File(Flat_File);
		FC.createNewFile();
		
		FileWriter FW = new FileWriter(Flat_File);
		BufferedWriter BW = new BufferedWriter(FW);
		BW.write(pp1.getTxt().getText());
		BW.close();
		
		pp1.getAdd_to_cart().click();
		
		pp1.getShopping_cart().click();
		
		String title8 = driver.getTitle();
		Assert.assertEquals(title8,"Shopping Cart");
		OpenCart_Shopping_Page sp = new OpenCart_Shopping_Page(driver);
		sp.getChckout().click();
		
		if(sp.getAlert_msg().isDisplayed()) {
			String Outofstock_error = null;
			rc.getss(Outofstock_error, driver);
		}
		String msg = "OUT OF STOCK, screenshot saved";
		System.out.println(msg);
		
		hp.getMy_act().click();
		hp.getLogout().click();
		
	}
	
	@DataProvider(name="logindata")
	public Object[][] getTestData() throws IOException
	{
		return rc.readDatafromExcel(0);
	}

}
