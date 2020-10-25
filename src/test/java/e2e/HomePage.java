package e2e;

import org.testng.annotations.Test;
import pageObjects.CookieDialog;
import pageObjects.LandingPage;
import pageObjects.LoginPage;
import resources.Base;

import java.io.IOException;

public class HomePage extends Base {

    @Test
    public void basePageNavigation() throws IOException {
        driver=initializeDriver();
        driver.manage().window().maximize();
        //parent link:https://phptravels.com/demo/
        driver.get("https://www.phptravels.net");

        CookieDialog c=new CookieDialog(driver);
        c.acceptCookie().click();

        LandingPage l=new LandingPage(driver);
        l.clickDropDown().click();
        l.getLogin().click();

        LoginPage lo=new LoginPage(driver);
        lo.enterEmail().sendKeys("user@phptravels.com");
        lo.enterPassword().sendKeys("demouser");
        lo.clickLogin().click();

    }
}
