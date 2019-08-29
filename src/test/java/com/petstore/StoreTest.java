package com.petstore;

import com.petstore.assertion.StatusCodeAssertion;
import com.petstore.utilities.StatusCodes;
import com.petstore.assertion.StoreAssertion;
import com.petstore.business.StoreBL;
import com.petstore.client.StoreServices;
import com.petstore.models.Order;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class StoreTest extends StoreServices {
    private static Order testStatOrder = new StoreBL().createOrder();
    private Response response;

    @Test
    public void postOrderTest() {
        response = postOrder(testStatOrder);
        Order newOrder = new StoreBL().createOrder();
        StoreAssertion.assertThat(response.getBody().as(Order.class)).isEqualTo(newOrder);
    }

    @Test
    public void getInventoryTest() {
        response = getInventory();
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.Success.getValue());
    }

    @Test
    public void getOrderByIdTest() {
        response = getOrderById(testStatOrder.getId());
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.Success.getValue());
    }

    @Test
    public void deleteOrderTest() {
        response = deleteOrder(testStatOrder.getId());
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.Success.getValue());
    }

    @Test
    public void getOrderByIdTestNeg() {
        response = getOrderById(123);
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.NotFoundError.getValue());
    }

    @Test
    public void deleteOrderTestNeg() {
        response = deleteOrder(123);
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.NotFoundError.getValue());
    }
}
