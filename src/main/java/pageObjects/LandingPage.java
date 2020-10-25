package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    By dropDownLogin=By.xpath("//div[@class='dropdown dropdown-login dropdown-tab']");
    By logIn=By.linkText("Login");

    public LandingPage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement clickDropDown()
    {
        return driver.findElement(dropDownLogin);
    }

    public WebElement getLogin()
   {
       return driver.findElement(logIn);
    }

}
