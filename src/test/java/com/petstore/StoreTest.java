package com.petstore;

import com.petstore.assertion.storeAssertions.StoreAssertion;
import com.petstore.business.StoreBL.StoreBL;
import com.petstore.client.store.StoreServices;
import com.petstore.models.Order;
import io.restassured.response.Response;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class StoreTest extends StoreServices {
    private static Order testStatOrder;
    private Order testOrder;

    @BeforeClass
    public static void setUp() {
        testStatOrder = new StoreBL().createOrder();
    }

    @Test(priority = 1)
    public void postOrderTest() {
        Response response = postOrder(testStatOrder);
        Order newOrder = new StoreBL().createOrder();
        StoreAssertion.assertThat(response.getBody().as(Order.class)).isEqualTo(newOrder);
    }

    @Test(priority = 2)
    public void getOrderByIdTest() {
        Response response = getOrderById(testStatOrder.getId());
        AssertJUnit.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 3)
    public void deleteOrderTest() {
        Response response = deleteOrder(testStatOrder.getId());
        AssertJUnit.assertEquals(200,response.getStatusCode());
    }
}
