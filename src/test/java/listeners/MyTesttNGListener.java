package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import base.BaseTest;

public class MyTesttNGListener extends BaseTest implements ITestListener{

	public void onTestStart(ITestResult result) {
		
	}

	public void onTestSuccess(ITestResult result) {
		
		System.out.println("***************Test Passed "+result.getName());
		ExtentTest test=(ExtentTest)result.getTestContext().getAttribute("test");
		test.log(Status.PASS,result.getName()+"  - Test passed");
	}

	public void onTestFailure(ITestResult result) {
		
		System.out.println("***************Test Failed "+result.getName());
		System.out.println(result.getThrowable().getMessage());
		ExtentTest test=(ExtentTest)result.getTestContext().getAttribute("test");
		test.log(Status.FAIL, result.getThrowable().getMessage());
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("***************Test Skipped "+result.getName());
		ExtentTest test=(ExtentTest)result.getTestContext().getAttribute("test");
		test.log(Status.SKIP,result.getName()+" - Test Skipped" );
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	public void onStart(ITestContext context) {
		
	}

	public void onFinish(ITestContext context) {
		
	}

	
	
}
