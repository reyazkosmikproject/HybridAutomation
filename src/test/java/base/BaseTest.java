package base;

import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import driver.DriverScript;
import reports.ExtentReportManager;

public class BaseTest {
	
	public static DriverScript ds;
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeTest
	public void beforeTest(ITestContext context)
	{
		
		reports=ExtentReportManager.getReports();
		test=reports.createTest(context.getCurrentXmlTest().getName());
		test.log(Status.INFO, "Starting Tests "+context.getCurrentXmlTest().getName());
		
		context.setAttribute("report", reports);
		context.setAttribute("test", test);
		
		ds=new DriverScript();
		ds.setReport(test);
		ds.setTestContext(context);
		context.setAttribute("driver", ds);
		
	}
	
	@BeforeMethod
	public void beforeMethod(ITestContext context)
	{
		
		System.out.println("*************Start of Before MEthod ******");
		
		test=(ExtentTest) context.getAttribute("test");
		ds=(DriverScript) context.getAttribute("driver");
		reports=(ExtentReports) context.getAttribute("report");
		
		System.out.println("*************End of Before MEthod ******");
	}
	
	@AfterTest
	public void afterTest(ITestContext context)
	{
		
		ds=(DriverScript) context.getAttribute("driver");
		reports=(ExtentReports) context.getAttribute("report");
		
		if(reports!=null)
		{
			reports.flush();
		}
		
	}
	
	@AfterMethod
	public void afterMethod(ITestContext context)
	{
		
		
		
	}

}
