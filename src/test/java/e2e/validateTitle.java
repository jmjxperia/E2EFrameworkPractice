package e2e;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

import java.io.IOException;

public class validateTitle extends Base {

    WebDriver driver;
    static Logger log= LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver=initializeDriver();
        log.info("Initialized driver for validating Title");
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        log.info("Link opened");
    }

    @Test
    public void basePageNavigation() {
        LandingPage l = new LandingPage(driver);
        Assert.assertEquals(l.getSpecialTitle().getText(),"SPECIAL OFFER");
        log.info("Validated title name Special Offer");
        Assert.assertEquals(l.getPopularTitle().getText(),"POPULAR ITEMS");
        log.info("Validated title name Popular Items");
        Assert.assertEquals(l.getFollowTitle().getText(),"FOLLOW US");
        log.info("Validated title name Follow Us");

    }

    @AfterTest
    public void closeWindow()
    {
        if(prop.getProperty("browser").equals("opera")) {
            driver.quit();//in opera ,close method doesn't close the browser after window is closed
            log.info("Closed Opera browser after validating titles");
        }else if(prop.getProperty("browser").equals("firefox")) {
            driver.close();
            log.info("Closed Firefox browser after validating titles");
        }
    }

}
