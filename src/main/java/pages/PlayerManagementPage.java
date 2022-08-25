package pages;

import driver.DriverProvider;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static data.Data.USER_NAME;
import static data.Data.USER_PASSWORD;

public class PlayerManagementPage extends BasePage {
    MainPage mainPage = new MainPage(DriverProvider.getDriver());

    @FindBy(xpath = "//input[@name='PlayerSearch[name]']")
    private WebElement searchByName;

    @FindBy(xpath = "//tbody//tr/td[4]")
    private List<WebElement> firstList;

    public PlayerManagementPage(WebDriver driver) {
        super(driver);
    }

    public void openPlayerManagementPage() {
        mainPage.doLogIn(USER_NAME, USER_PASSWORD);
        mainPage.clickUserBoxIcon();
    }

    public void setSearchByName(String name) {
        searchByName.sendKeys(name);
        searchByName.sendKeys(Keys.ENTER);
    }

    public List<WebElement> getList() {
        return firstList;
    }
}
