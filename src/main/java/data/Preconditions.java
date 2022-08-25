package data;

import io.restassured.http.ContentType;
import pojo.AuthRequest;
import pojo.AuthResponse;
import pojo.ResourceOwnerRequest;
import pojo.ResourceOwnerResponse;

import static data.Data.*;
import static io.restassured.RestAssured.given;
import static utils.PathResolver.ACCESS_TOKEN;


public abstract class Preconditions {
    static AuthRequest authRequest;
    static AuthResponse authResponse;
    static ResourceOwnerRequest resourceOwnerRequest;
    static ResourceOwnerResponse resourceOwnerResponse;

    public static String getBasicToken() {
        authRequest = new AuthRequest.AuthRequestBuilder()
                .withGrant_type(GUEST_GRANT_TYPE)
                .withScope(SCOPE)
                .build();
        authResponse = given()
                .auth()
                .preemptive()
                .basic(BASIC_AUTH, "")
                .with()
                .contentType(ContentType.JSON)
                .body(authRequest)
                .when()
                .post(ACCESS_TOKEN)
                .then()
                .extract().as(AuthResponse.class);
        return authResponse.getAccess_token();
    }

    public static String getUserToken(){
        resourceOwnerRequest = new ResourceOwnerRequest.ResourceOwnerRequestBuilder()
                .withGrant_type(USER_GRANT_TYPE)
                .withUsername(USERNAME)
                .withPassword(PASSWORD).build();
        resourceOwnerResponse = given()
                .auth()
                .preemptive()
                .basic(BASIC_AUTH,"")
                .with()
                .contentType(ContentType.JSON)
                .body(resourceOwnerRequest)
                .when()
                .post(ACCESS_TOKEN)
                .then()
                .extract().as(ResourceOwnerResponse.class);
        return resourceOwnerResponse.getAccess_token();
    }
}
