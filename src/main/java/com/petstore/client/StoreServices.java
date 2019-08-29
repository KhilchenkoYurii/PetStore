package com.petstore.client;

import com.petstore.models.Order;

import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class StoreServices extends SetUp {

    public StoreServices() {
        super(Paths.storeUrl);
    }

    public Response postOrder(Order order) {
        return given(createRequest())
                .body(order)
                .post("" + Paths.storeOrderUrl);
    }

    public Response getInventory() {
        return given(createRequest())
                .get(Paths.storeInventoryUrl);
    }

    public  Response getOrderById(int id) {
        return given(createRequest())
                .get(Paths.storeOrderUrl + id);
    }

    public Response deleteOrder(int id) {
        return given(createRequest())
                .delete(Paths.storeOrderUrl + id);
    }
}
