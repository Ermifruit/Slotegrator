package StepDefinitions;

import driver.DriverProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.MainPage;

import static StepDefinitions.BaseTest.START_URL;
import static data.Data.USER_NAME;
import static data.Data.USER_PASSWORD;

public class MainPageStepDefinition {
    MainPage mainPage = new MainPage(DriverProvider.getDriver());


    @Given("^user is logged in and is on the main page$")
    public void userIsLoggedInAndIsOnTheMainPage() {
        mainPage.doLogIn(USER_NAME, USER_PASSWORD);
    }

    @When("^user click on icon player management$")
    public void userClickOnPanelPlayersOnlineTotal() {
        mainPage.clickUserBoxIcon();
    }

    @Then("^user can download CSV file$")
    public void userCanDownloadCSVFile() {
        Assert.assertTrue(mainPage.getExportButton());
    }
}
