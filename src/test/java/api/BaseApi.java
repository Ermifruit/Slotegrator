package api;

import io.restassured.RestAssured;
import org.testng.annotations.BeforeClass;
import utils.PropertyHelper;

public class BaseApi {
    @BeforeClass
    public void setup() {
        String systemHost = System.getProperty("api.base.url");
        String projectHost = PropertyHelper.getProperty("api.base.url");
        if (null == systemHost) {
            if (null == projectHost) {
                RestAssured.baseURI = "http://localhost";
            } else {
                RestAssured.baseURI = projectHost;
            }
        } else {
            RestAssured.baseURI = systemHost;
        }
    }
}
