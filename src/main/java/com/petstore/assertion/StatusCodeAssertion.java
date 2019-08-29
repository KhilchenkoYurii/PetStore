package com.petstore.assertion;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.asserts.SoftAssert;



public class StatusCodeAssertion {
    public static void statusCodeAssert(Response response, int statusCode) {
        SoftAssert softAssertions = new SoftAssert();
        softAssertions.assertEquals(response.getContentType(), ContentType.JSON.toString());
        softAssertions.assertEquals(response.getStatusCode(),statusCode);
        softAssertions.assertAll();
    }
}
