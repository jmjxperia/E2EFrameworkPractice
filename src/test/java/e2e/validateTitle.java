package e2e;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

import java.io.IOException;

public class validateTitle extends Base {

    @Test
    public void basePageNavigation() throws IOException {
        driver = initializeDriver();
        driver.manage().window().maximize();

        driver.get(prop.getProperty("url"));

        LandingPage l = new LandingPage(driver);
        Assert.assertEquals(l.getSpecialTitle().getText(),"SPECIAL OFFER");
        Assert.assertEquals(l.getPopularTitle().getText(),"POPULAR ITEMS");
        Assert.assertEquals(l.getFollowTitle().getText(),"FOLLOW US");

    }
}
