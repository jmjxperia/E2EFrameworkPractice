package e2e;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

import java.io.IOException;

public class HomePage extends Base {

    WebDriver driver;
    static Logger log= LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver=initializeDriver();
        log.info("Initialized driver for Login");
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        log.info("Link opened");
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String userName,String pwd) {
        LandingPage l=new LandingPage(driver);
        l.clickLoginHeader().click();
        log.info("Clicked on Login Header");
        l.enterUsername().sendKeys(userName);
        log.info("Entered username");
        l.enterPassword().sendKeys(pwd);
        log.info("Entered password");
        l.clickLogin().click();
        log.info("Clicked login");

    }


    @DataProvider
    public Object[][] getData()
    {
        Object[][] data=new Object[1][2];

            data[0][0] = "imtester";
            data[0][1] = "qwertyQaz1";

        return data;
    }

    @AfterTest
    public void closeWindow()
    {
        if(prop.getProperty("browser").equals("opera")) {
            driver.quit();//in opera ,close method doesn't close the browser after window is closed
            log.info("Closed Opera browser after login");
        }else if(prop.getProperty("browser").equals("firefox")) {
            driver.close();
            log.info("Closed Firefox browser after login");
        }
    }
}
