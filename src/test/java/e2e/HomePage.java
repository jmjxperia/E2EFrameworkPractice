package e2e;

import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

import java.io.IOException;

public class HomePage extends Base {

    @Test
    public void basePageNavigation() throws IOException {
        driver=initializeDriver();
        //parent link:https://phptravels.com/demo/
        driver.get("https://www.phptravels.net");
        LandingPage l=new LandingPage(driver);
        l.clickDropDown().click();
        l.getLogin().click();

    }
}
