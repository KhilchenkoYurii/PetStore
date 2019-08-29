package com.petstore.client.store;

import com.petstore.client.SetUp;
import com.petstore.models.Order;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StoreServices extends SetUp {

    public StoreServices() {
        super(StorePath.storeOrderUrl);
    }

    public Response postOrder(Order order) {
        return given(createRequest())
                .body(order)
                .post();
    }

    public  Response getOrderById(int id) {
        return given(createRequest())
                .get("" + id);
    }

    public Response deleteOrder(int id) {
        return given(createRequest())
                .delete("" + id);
    }
}
