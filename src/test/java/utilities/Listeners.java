package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import pageObjectstestCases.BaseClass;

public class Listeners extends ExtentReport implements ITestListener{
	
	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("Test Case ---> "+
	result.getMethod().getMethodName() + "---- Started");
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case ---> "+
				result.getMethod().getMethodName() + "---- Passed");
		test = extent.createTest(result.getName());
		test.log(Status.PASS, "Test case is PASSED :" +result.getName());
	}

	@Override
	public void onTestFailure(ITestResult result) {
		Object currentclass = result.getInstance();
		WebDriver driver = ((BaseClass)currentclass).driver;
		String testname = result.getName();
		Screenshot.getScreenshot(driver, testname);
		
		test = extent.createTest(result.getName());
		test.log(Status.FAIL, "Test case is FAILED :"+result.getName());
		test.log(Status.FAIL, "Test case FAILED cause is :"+result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		test = extent.createTest(result.getName());
		test.log(Status.SKIP, "Test case is SKIPPED :"+result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		ExtentReport.ExtentReports();
	}

	@Override
	public void onFinish(ITestContext context) {
		        extent.flush();
		    }
}
