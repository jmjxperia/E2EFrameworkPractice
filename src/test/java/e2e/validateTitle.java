package e2e;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

import java.io.IOException;

public class validateTitle extends Base {

    @BeforeTest
    public void initialize() throws IOException {
        driver=initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @Test
    public void basePageNavigation() {
        LandingPage l = new LandingPage(driver);
        Assert.assertEquals(l.getSpecialTitle().getText(),"SPECIAL OFFER");
        Assert.assertEquals(l.getPopularTitle().getText(),"POPULAR ITEMS");
        Assert.assertEquals(l.getFollowTitle().getText(),"FOLLOW US");

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
