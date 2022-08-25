package api;

import data.Preconditions;
import io.restassured.http.ContentType;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojo.*;

import java.util.List;

import static data.Data.*;
import static io.restassured.RestAssured.given;
import static java.net.HttpURLConnection.*;
import static utils.PathResolver.*;

public class CasinoApiTest extends BaseApi {
    AuthRequest authRequest;
    AuthResponse authResponse;
    ResourceOwnerRequest resourceOwnerRequest;
    ResourceOwnerResponse resourceOwnerResponse;
    PlayerRequest playerRequest;
    PlayerResponse playerResponse;

    @Test(priority = 1)
    public void authorizationInTheSystemAsAGuestTest(){
        authRequest = new AuthRequest.AuthRequestBuilder()
                .withGrant_type(GUEST_GRANT_TYPE)
                .withScope(SCOPE)
                .build();
        authResponse = given()
                .auth()
                .preemptive()
                .basic(BASIC_AUTH,"")
                .with()
                .contentType(ContentType.JSON)
                .body(authRequest)
                .when()
                .post(ACCESS_TOKEN)
                .then()
                .log().everything()
                .statusCode(HTTP_OK)
                .extract().as(AuthResponse.class);
        Assert.assertNotNull(authResponse.getAccess_token());
    }

    @Test(priority = 2)
    public void registrationNewUserTest() {
        playerRequest = new PlayerRequest.PlayerRequestBuilder()
                .withUsername(USERNAME)
                .withPassword_change(PASSWORD)
                .withPassword_repeat(CONFIRM_PASSWORD)
                .withEmail(EMAIL)
                .withName(NAME)
                .build();
        playerResponse = given()
                .header("Authorization", "Bearer " + Preconditions.getBasicToken())
                .contentType(ContentType.JSON)
                .body(playerRequest)
                .when()
                .post(PLAYER)
                .then()
                .log().everything()
                .statusCode(HTTP_CREATED)
                .extract().as(PlayerResponse.class);
        Assert.assertNotNull(playerResponse.getId());
        Assert.assertEquals(playerResponse.getUsername(), USERNAME);
        Assert.assertEquals(playerResponse.getEmail(), EMAIL);
        Assert.assertEquals(playerResponse.getName(), NAME);
    }

    @Test(priority = 3)
    public void LogInWithCreatedPlayerTest(){
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
                .log().everything()
                .statusCode(HTTP_OK)
                .extract().as(ResourceOwnerResponse.class);
        Assert.assertNotNull(resourceOwnerResponse.getAccess_token());
        Assert.assertNotNull(resourceOwnerResponse.getRefresh_token());
    }



    @Test(priority = 4)
    public void getPlayerProfileDataTest() {
        List<PlayerResponse> playerResponses =
                given()
                        .header("Authorization", "Bearer " + Preconditions.getUserToken())
                        .contentType(ContentType.JSON)
                        .when()
                        .get(PLAYER)
                        .then()
                        .log().everything()
                        .statusCode(HTTP_OK)
                        .extract().jsonPath().getList("", PlayerResponse.class);
        for (PlayerResponse player : playerResponses
        ) {
            Assert.assertNotNull(player.getId());
            Assert.assertEquals(player.getUsername(), USERNAME);
            Assert.assertEquals(player.getEmail(), EMAIL);
            Assert.assertEquals(player.getName(), NAME);
        }
    }

    @Test(priority = 5)
    public void getAnotherPlayerProfileDataTest() {
        given()
                .header("Authorization", "Bearer " + Preconditions.getUserToken())
                .contentType(ContentType.JSON)
                .when()
                .get(PLAYER + BAD_USER_ID)
                .then()
                .log().everything()
                .statusCode(HTTP_NOT_FOUND);
    }
}
