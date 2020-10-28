package e2e;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

import java.io.IOException;

public class HomePage extends Base {

    WebDriver driver;
    static Logger log = LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver = initializeDriver();
        log.info("Initialized driver for Login");
        driver.manage().window().maximize();

    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String userName, String pwd) throws InterruptedException {
        driver.get(prop.getProperty("url"));
        log.info("Link opened");
        LandingPage l = new LandingPage(driver);
        l.clickLoginHeader().click();
        log.info("Clicked on Login Header");
        l.enterUsername().sendKeys(userName);
        log.info("Entered username");
        l.enterPassword().sendKeys(pwd);
        log.info("Entered password");
        l.clickLogin().click();
        log.info("Clicked login");
        Thread.sleep(3500);
        Assert.assertFalse(l.getMessage().isDisplayed());

    }


    @DataProvider
    public Object[][] getData() {
        Object[][] data = new Object[2][2];

        data[0][0] = "imtester";
        data[0][1] = "qwertyQaz1";

        //user not created
        data[1][0] = "imtester1";
        data[1][1] = "qwertyQaz2";
        return data;
    }

    @AfterTest
    public void closeWindow() {
        if (prop.getProperty("browser").equals("opera")) {
            driver.quit();//in opera ,close method doesn't close the browser after window is closed
            log.info("Closed Opera browser after login");
        } else if (prop.getProperty("browser").equals("firefox")) {
            driver.close();
            log.info("Closed Firefox browser after login");
        }
    }
}
