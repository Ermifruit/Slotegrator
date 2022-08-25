package pages;

import driver.DriverProvider;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MainPage extends BasePage {
    LogInPage logInPage = new LogInPage(DriverProvider.getDriver());
    @FindBy(xpath = "//i[@class='fa fa-user']")
    private WebElement userLogo;

    @FindBy(xpath = "//span[@class='box-icon bg-twitter']")
    private WebElement userBoxIcon;

    @FindBy(xpath = "//a[@class='btn btn-warning export']")
    private WebElement exportButton;

    public MainPage(WebDriver driver) {
        super(driver);
    }

    public void doLogIn(String username, String password){
        logInPage.setUsername(username);
        logInPage.setPassword(password);
        logInPage.clickSignInBtn();
    }

    public boolean getUserLogo() {
        return userLogo.isDisplayed();
    }

    public void clickUserBoxIcon(){
        userBoxIcon.click();
    }

    public boolean getExportButton(){
        return exportButton.isDisplayed();
    }
}
