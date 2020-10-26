package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    By loginHeader=By.id("menuUserLink");
    By username=By.xpath("//input[@name='username']");
    By password=By.xpath("//input[@name='password']");
    By login=By.cssSelector("[id='sign_in_btnundefined']");

    public LandingPage(WebDriver driver) {
        this.driver=driver;
    }


    public WebElement enterUsername()
    {
        return driver.findElement(username);
    }

    public WebElement enterPassword()
    {
        return driver.findElement(password);
    }

    public  WebElement clickLogin()
    {
        return  driver.findElement(login);
    }


    public WebElement clickLoginHeader()
    {
        return driver.findElement(loginHeader);
    }


}
