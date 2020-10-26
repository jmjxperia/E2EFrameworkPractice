package resources;

import org.apache.poi.ss.usermodel.PageOrder;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

    public  WebDriver driver;
    public Properties prop;
    public WebDriver initializeDriver() throws IOException {
        prop=new Properties();
        FileInputStream fis=new FileInputStream("C:\\Users\\Jathin\\IdeaProjects\\Framework\\src\\main\\java\\resources\\data.properties");
        prop.load(fis);
        String browserName=prop.getProperty("browser");

        if(browserName.equals("opera"))
        {
            System.setProperty("webdriver.opera.driver","C:\\Users\\Jathin\\Downloads\\Compressed\\operadriver_win64\\operadriver_win64\\operadriver.exe");
            driver=new OperaDriver();

        } else if(browserName.equals("firefox"))
        {
            System.setProperty("webdriver.gecko.driver","C:\\Users\\Jathin\\Downloads\\Compressed\\geckodriver-v0.27.0-win64\\geckodriver.exe");
            driver=new FirefoxDriver();
        }

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
