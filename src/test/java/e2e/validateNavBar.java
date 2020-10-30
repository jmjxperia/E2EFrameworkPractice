package e2e;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

import java.io.IOException;

public class validateNavBar extends Base{

    WebDriver driver;
    static Logger log= LogManager.getLogger(Base.class.getName());

    @BeforeTest
    public void initialize() throws IOException {
        driver=initializeDriver();
        log.info("Initialized driver for Validating Navigation Bar");
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
        log.info("Link opened");
    }

    @Test
    public void validateNavBar()  {
        WebDriverWait w=new WebDriverWait(driver,10);
        LandingPage l = new LandingPage(driver);
        w.until(ExpectedConditions.visibilityOfElementLocated(l.locatorProduct()));
        Assert.assertTrue(l.getProductsNavigation().isDisplayed());
        log.info("Our Products is displayed");
        Assert.assertEquals(l.getSpecialNavigation().getText(), "SPECIAL OFFER");
        log.info("Validated Special Offer from Navigation bar");
        Assert.assertEquals(l.getPopularNavigation().getText(), "POPULAR ITEMS");
        log.info("Validated Popular Items from Navigation bar");
        Assert.assertEquals(l.getContactNavigation().getText(), "CONTACT US");
        log.info("Validated Contact Us from Navigation bar");
    }

    @AfterTest
    public void closeWindow()
    {
        if(prop.getProperty("browser").equals("opera")) {
            driver.quit();//in opera ,close method doesn't close the browser after window is closed
            log.info("Closed Opera browser after validating navigation bar");
        }else if(prop.getProperty("browser").equals("firefox")) {
            driver.close();
            log.info("Closed Firefox browser after validating navigation bar");
        }
    }
}