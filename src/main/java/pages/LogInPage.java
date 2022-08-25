package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {
    @FindBy(css = ".logo")
    private WebElement logo;

    @FindBy(id = "UserLogin_username")
    private WebElement username;

    @FindBy(id = "UserLogin_password")
    private WebElement password;

    @FindBy(xpath = "//input[@value='Sign in']")
    private WebElement signInBtn;


    public LogInPage(WebDriver driver) {
        super(driver);
    }

    public void getLogo() {
        logo.getAttribute("Casino");
    }

    public void setUsername(String username) {
        this.username.sendKeys(username);
    }

    public void setPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickSignInBtn() {
        signInBtn.click();
    }

}
