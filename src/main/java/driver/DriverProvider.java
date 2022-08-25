package driver;

import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

import static utils.TimeOuts.ELEMENT_TIMEOUT;
import static utils.TimeOuts.PAGE_LOAD_TIMEOUT;

public class DriverProvider {
    private static WebDriver driver;

    private DriverProvider() {
    }

    public static WebDriver getDriver() {
        if (driver == null) {
            driver = ChromeLauncher.createDriver();
            driver.manage().timeouts().pageLoadTimeout(PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().implicitlyWait(ELEMENT_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().timeouts().setScriptTimeout(ELEMENT_TIMEOUT, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
