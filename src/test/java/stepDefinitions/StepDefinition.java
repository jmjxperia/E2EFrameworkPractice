package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import pageObjects.LandingPage;
import resources.Base;

import java.io.IOException;

@RunWith(Cucumber.class)
public class StepDefinition extends Base {
    LandingPage l;

    @Given("Intialize the browser with opera")
    public void intialize_the_browser_with_opera() throws IOException {
        driver = initializeDriver();
    }


    @Given("Navigate to {string} site")
    public void navigate_to_site(String url) {
        driver.get(url);
    }
    @Given("Click on the login header to enter credentials")
    public void click_on_the_login_header_to_enter_credentials() {
        l = new LandingPage(driver);
        l.clickLoginHeader().click();
    }
    @When("User enters username {string} and password {string}")
    public void user_enters_username_and_password(String userName, String pwd) throws InterruptedException {
        l.enterUsername().sendKeys(userName);
        l.enterPassword().sendKeys(pwd);
        Thread.sleep(3500);
        l.clickLogin().click();
    }
    @Then("Verify user is successfully logged in")
    public void verify_user_is_successfully_logged_in() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
