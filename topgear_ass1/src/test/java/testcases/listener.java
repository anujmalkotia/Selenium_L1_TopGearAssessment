package testcases;

 

import java.io.IOException;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import resources.extent_report;
import utilities.ReusableComponents;

 

public class listener implements ITestListener
{

 

    ReusableComponents re=new ReusableComponents();
    ExtentTest test;
    ExtentReports extent= extent_report.getExtentreportobject();
    ThreadLocal<ExtentTest> extentTest=new ThreadLocal<ExtentTest>();
    
    @Override
    public void onTestStart(ITestResult result)
    {
        test=extent.createTest(result.getMethod().getMethodName());
        extentTest.set(test);
    }
    @Override
    public void onTestSuccess(ITestResult result) 
    {
        extentTest.get().log(Status.PASS, "TestCase passed Successfully");        
    }
    @Override
    public void onTestFailure(ITestResult result) 
    {
        extentTest.get().fail(result.getThrowable());
        WebDriver Driver=null;
        String testmethodname=result.getMethod().getMethodName();
        
        try
        {
            Driver=(WebDriver) result.getTestClass().getRealClass().getDeclaredField("Driver").get(result.getInstance());    
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        try
        {
            extentTest.get().addScreenCaptureFromPath(re.getss(testmethodname,Driver),testmethodname);
        }
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
    public void onFinish(ITestContext context) 
    {
        extent.flush();
    }
    
    
    
}