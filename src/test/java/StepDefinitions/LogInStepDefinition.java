package StepDefinitions;

import driver.DriverProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.LogInPage;
import pages.MainPage;

import static StepDefinitions.BaseTest.START_URL;
import static data.Data.USER_NAME;
import static data.Data.USER_PASSWORD;

public class LogInStepDefinition {
    LogInPage logInPage = new LogInPage(DriverProvider.getDriver());
    MainPage mainPage = new MainPage(DriverProvider.getDriver());

    @Given("^user is on log in page$")
    public void userIsOnLogInPage() {
        logInPage.getLogo();
    }

    @When("^user set user name and password$")
    public void userSetUserNameAndPassword() {
        logInPage.setUsername(USER_NAME);
        logInPage.setPassword(USER_PASSWORD);
    }

    @And("^user click sign in button$")
    public void userClickSignInButton() {
        logInPage.clickSignInBtn();
    }

    @Then("^user is on main page$")
    public void userIsOnMainPage() {
        Assert.assertTrue(mainPage.getUserLogo());
    }
}
