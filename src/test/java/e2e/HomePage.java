package e2e;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
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
    public void checkLogin(String userName, String pwd) throws InterruptedException {
        driver.get(prop.getProperty("url"));
        log.info("Link opened");
        LandingPage l = new LandingPage(driver);
        l.clickLoginHeader().click();
        log.info("Clicked on Login Header");
        l.enterUsername().sendKeys(userName);
        log.info("Entered username");
        l.enterPassword().sendKeys(pwd);
        log.info("Entered password");
        Thread.sleep(3500);
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

    @Test
    public void validateTitle() {
        LandingPage l = new LandingPage(driver);
        Assert.assertEquals(l.getSpecialTitle().getText(),"SPECIAL OFFER");
        log.info("Validated title name Special Offer");
        Assert.assertEquals(l.getPopularTitle().getText(),"POPULAR ITEMS");
        log.info("Validated title name Popular Items");
        Assert.assertEquals(l.getFollowTitle().getText(),"FOLLOW US");
        log.info("Validated title name Follow Us");

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
