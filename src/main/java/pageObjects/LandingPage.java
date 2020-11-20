package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public WebDriver driver;

    private By loginHeader=By.id("menuUserLink");
    private By username=By.xpath("//input[@name='username']");
    private By password=By.xpath("//input[@name='password']");
    private By login=By.cssSelector("[id='sign_in_btnundefined']");
    private By message=By.xpath("//label[@id='signInResultMessage']");
    //By indexing
    private By sTitle=By.xpath("(//h3[@class='roboto-regular center ng-scope'])[1]");
    //By Parent-child
    private By pTitle=By.xpath("//article[@id='popular_items'] //h3[@class='roboto-regular center ng-scope']");
    private By fTitle=By.xpath("//h3[contains(text(),'FOLLOW US')]");

    private By proNav=By.xpath("//a[contains(text(),'OUR PRODUCTS')]");
    private By spNav=By.xpath("//a[contains(text(),'SPECIAL OFFER')]");
    private By pNav=By.xpath("//a[contains(text(),'POPULAR ITEMS')]");
    private By cNav=By.xpath("//a[contains(text(),'CONTACT US')]");

    private By verifyUser=By.xpath("//span[@class='hi-user containMiniTitle ng-binding']");

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

    public  WebElement verifyUsername()
    {
        return driver.findElement(verifyUser);
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

    public  WebElement getMessage()
    {
        return driver.findElement(message);
    }

    public By locatorProduct()
    {
        return proNav;
    }

    public By locatorLogin()
    {
        return login;
    }
}
