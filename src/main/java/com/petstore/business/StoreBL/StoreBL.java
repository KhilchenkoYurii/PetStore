package com.petstore.business.StoreBL;

import com.petstore.client.store.StoreServices;
import com.petstore.models.Order;
import com.petstore.models.OrderStatus;
import com.sun.org.apache.xpath.internal.operations.Or;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;

public class StoreBL {
    private int id = Integer.parseInt(RandomStringUtils.randomNumeric(5));

    public Order createOrder() {
        Order order = Order.builder()
                .id(id)
                .petId(id)
                .quantity(id)
                .shipDate(RandomStringUtils.randomAlphabetic(8))
                .status(OrderStatus.Approved)
                .complete(false)
                .build();
        return order;
    }

    public Order orderFromJson(int id) {
        Response response = new StoreServices().getOrderById(id);
        Order order = response.as(Order.class);
        return order;

    }
}
