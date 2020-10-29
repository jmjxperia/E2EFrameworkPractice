package e2e;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;
import resources.ExtentReporterNG;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {
    ExtentTest test;
    ExtentReports extent = ExtentReporterNG.getReportObject();

    @Override
    public void onTestStart(ITestResult result) {
        test=extent.createTest(result.getMethod().getMethodName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS,"Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
        WebDriver driver=null;
        String testMethodName=result.getMethod().getMethodName();
        try {
            driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            test.addScreenCaptureFromPath(getScreenshotPath(testMethodName,driver),testMethodName);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}
