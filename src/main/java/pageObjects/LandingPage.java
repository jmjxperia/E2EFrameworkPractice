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
    //By indexing
    By sTitle=By.xpath("(//h3[@class='roboto-regular center ng-scope'])[1]");
    //By Parent-child
    By pTitle=By.xpath("//article[@id='popular_items'] //h3[@class='roboto-regular center ng-scope']");
    By fTitle=By.xpath("//h3[contains(text(),'FOLLOW US')]");

    By proNav=By.xpath("//a[contains(text(),'OUR PRODUCTS')]");
    By spNav=By.xpath("//a[contains(text(),'SPECIAL OFFER')]");
    By pNav=By.xpath("//a[contains(text(),'POPULAR ITEMS')]");
    By cNav=By.xpath("//a[contains(text(),'CONTACT US')]");

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

    public WebElement getSpecialTitle()
    {
        return driver.findElement(sTitle);
    }

    public WebElement getPopularTitle()
    {
        return driver.findElement(pTitle);
    }

    public WebElement getFollowTitle()
    {
        return driver.findElement(fTitle);
    }

    public WebElement getProductsNavigation()
    {
        return driver.findElement(proNav);
    }

    public WebElement getSpecialNavigation()
    {
        return driver.findElement(spNav);
    }

    public WebElement getPopularNavigation()
    {
        return driver.findElement(pNav);
    }

    public WebElement getContactNavigation()
    {
        return driver.findElement(cNav);
    }

    public By locatorProduct()
    {
        return proNav;
    }

}
