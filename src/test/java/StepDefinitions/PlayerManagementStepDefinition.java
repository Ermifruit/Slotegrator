package StepDefinitions;

import driver.DriverProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import pages.PlayerManagementPage;

import static StepDefinitions.BaseTest.START_URL;
import static data.Data.SEARCH_PARAM;

public class PlayerManagementStepDefinition {
    PlayerManagementPage playerManagementPage = new PlayerManagementPage(DriverProvider.getDriver());

    @Given("user is on player management page")
    public void userIsOnPlayerManagementPage() {
        playerManagementPage.openPlayerManagementPage();
    }

    @When("user sort table by name")
    public void userEnterANameInTheSortField() throws InterruptedException {
        playerManagementPage.setSearchByName(SEARCH_PARAM);
        Thread.sleep(1000);

    }

    @Then("check if the table is sorted")
    public void checkIfTheTableIsSorted() {
        for (WebElement name : playerManagementPage.getList()
                ) {
            Assert.assertEquals(name.getText(), SEARCH_PARAM);
        }
    }
}
