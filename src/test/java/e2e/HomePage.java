package e2e;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import resources.Base;

import java.io.IOException;

public class HomePage extends Base {

    @BeforeTest
    public void initialize() throws IOException {
        driver=initializeDriver();
        driver.manage().window().maximize();
        driver.get(prop.getProperty("url"));
    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String email,String pwd) {
        LandingPage l=new LandingPage(driver);
        l.clickLoginHeader().click();
        l.enterUsername().sendKeys(email);
        l.enterPassword().sendKeys(pwd);
        l.clickLogin().click();

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
        if(prop.getProperty("browser").equals("opera"))
            driver.quit(); //in opera ,close method doesn't close the browser after window is closed
        else if(prop.getProperty("browser").equals("firefox"))
            driver.close();
    }
}
