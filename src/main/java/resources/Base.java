package resources;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public  WebDriver driver;
    public Properties prop;
    public WebDriver initializeDriver() throws IOException {
        prop=new Properties();
        String projectPath=System.getProperty("user.dir");
        FileInputStream fis=new FileInputStream(projectPath+"\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browserName=prop.getProperty("browser");

        if(browserName.equals("opera"))
        {
            System.setProperty("webdriver.opera.driver",projectPath+"\\drivers\\operadriver.exe");
            driver=new OperaDriver();

        } else if(browserName.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver",projectPath+"\\drivers\\geckodriver.exe");
            driver=new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

    public void getScreenshotPath(String testCaseName,WebDriver driver) throws IOException {
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);
        File destination= new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");
        FileUtils.copyFile(source,destination);

    }
}
