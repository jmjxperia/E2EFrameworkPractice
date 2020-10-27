package e2e;

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

    @BeforeTest
    public void initialize() throws IOException {
        driver=initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void basePageNavigation()  {
        WebDriverWait w=new WebDriverWait(driver,10);
        LandingPage l = new LandingPage(driver);
        w.until(ExpectedConditions.visibilityOfElementLocated(l.locatorProduct()));
        Assert.assertTrue(l.getProductsNavigation().isDisplayed());
        Assert.assertEquals(l.getSpecialNavigation().getText(), "SPECIAL OFFER");
        Assert.assertEquals(l.getPopularNavigation().getText(), "POPULAR ITEMS");
        Assert.assertEquals(l.getContactNavigation().getText(), "CONTACT US");
    }

    @AfterTest
    public void closeWindow()
    {
        if(prop.getProperty("browser").equals("opera"))
            driver.quit(); //in opera ,close method doesn't close the browser after window is closed
        else if(prop.getProperty("browser").equals("firefox"))
            driver.close();
    }
}