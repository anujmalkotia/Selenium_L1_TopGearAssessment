package resources;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
public class extent_report 
{    public static ExtentReports extent;

 

    public static ExtentReports getExtentreportobject()
    {
        String path="./reports\\index.html";        
        ExtentSparkReporter reporter=new ExtentSparkReporter(path);
        
        reporter.config().setReportName("Neeraj 40063991 casestudy1");
        reporter.config().setDocumentTitle("Neeraj 40063991");
        
        extent=new ExtentReports();
        extent.attachReporter(reporter);
        extent.setSystemInfo("Name", "Neeraj Pal Singh");
        extent.setSystemInfo("Empi id", "40063991");
        
        return extent;
    }
    
}
 