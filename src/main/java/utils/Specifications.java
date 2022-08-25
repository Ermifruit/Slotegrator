package utils;


import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;

import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;


public class Specifications {
    public static RequestSpecification requestSpec() {
        return new RequestSpecBuilder()
                .setBaseUri(PropertyHelper.getProperty("api.base.url"))
                .setContentType(ContentType.JSON)
                .build();
    }

    public static void installRequest(RequestSpecification request){
        RestAssured.requestSpecification = request;
    }

}
