package StepDefinitions;

import driver.DriverProvider;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.PropertyHelper;

public class BaseTest {
    public static final String START_URL = PropertyHelper.getProperty("start.url");

    @Before
    public void beforeClass() {
        WebDriver driver = DriverProvider.getDriver();
        driver.get(START_URL);
    }

    @After
    public void afterClass() {
        DriverProvider.tearDown();
    }
}
