package com.petstore.business;

import com.petstore.client.StoreServices;
import com.petstore.models.GetDate;
import com.petstore.models.Order;
import com.petstore.models.Status;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;

public class StoreBL {
    private int id = Integer.parseInt(RandomStringUtils.randomNumeric(5));

    public Order createOrder() {
        Order order = Order.builder()
                .id(id)
                .petId(id)
                .quantity(id)
                .shipDate(GetDate.getShipDate())
                .status(Status.Placed.getValue())
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
