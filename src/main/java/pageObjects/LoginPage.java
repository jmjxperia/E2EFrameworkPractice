package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public WebDriver driver;

    By email=By.cssSelector("[name='username']");
    By password=By.cssSelector("[name='password']");
    By login=By.xpath("//button[@class='btn btn-primary btn-lg btn-block loginbtn']");

    public LoginPage(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement enterEmail()
    {
        return driver.findElement(email);
    }

    public WebElement enterPassword()
   {
       return driver.findElement(password);
    }

    public  WebElement clickLogin()
    {
        return  driver.findElement(login);
    }
}
