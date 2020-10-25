package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookieDialog {

    public WebDriver driver;

    By cookie=By.xpath("//button[@class='cc-btn cc-dismiss']");

    public CookieDialog(WebDriver driver) {
        this.driver=driver;
    }

    public WebElement acceptCookie()
    {
        return driver.findElement(cookie);
    }
}
