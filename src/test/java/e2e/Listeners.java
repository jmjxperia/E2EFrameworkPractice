package e2e;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import resources.Base;

import java.io.IOException;

public class Listeners extends Base implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver=null;
        String testMethodName=result.getMethod().getMethodName();
        try {
            driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            getScreenshotPath(testMethodName,driver);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
