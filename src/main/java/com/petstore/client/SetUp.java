package com.petstore.client;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class SetUp {
    private RequestSpecification specification;
    private String pathUri;

    public SetUp(String pathUri) {
        this.pathUri = pathUri;
    }

    public RequestSpecification createRequest() {
        specification = new RequestSpecBuilder()
                .addHeader("api_key", "12345678")
                .setBaseUri("http://petstore.swagger.io")
                .setBasePath(pathUri)
                .setContentType(ContentType.JSON)
                .build();
        return specification;
    }
}
