package com.petstore.assertion.storeAssertions;

import com.petstore.client.store.StorePath;
import com.petstore.models.Order;
import com.petstore.models.OrderStatus;
import org.assertj.core.api.SoftAssertions;

public class StoreAssertion {
    SoftAssertions softAssertions = new SoftAssertions();
    private static Order actual;

    public static StoreAssertion assertThat(Order order) {
        actual = order;
        return new StoreAssertion();
    }

    public void hasId(int id) {
        int actualId = actual.getId();
        softAssertions.assertThat(actualId).as("Id").isEqualTo(id);
    }

    public void hasPetId(int id) {
        int actualPetId = actual.getPetId();
        softAssertions.assertThat(actualPetId).as("PetId").isEqualTo(id);
    }

    public void hasQuantity(int quantity) {
        int actualQuantity = actual.getQuantity();
        softAssertions.assertThat(actualQuantity).as("Quantity").isEqualTo(quantity);
    }

    public void hasShipDate(String  shipDate) {
        String actualShipDate = actual.getShipDate();
        softAssertions.assertThat(actualShipDate).as("ShipDate").isEqualTo(shipDate);
    }

    public void hasStatus(OrderStatus status) {
        OrderStatus actualStatus = actual.getStatus();
        softAssertions.assertThat(actualStatus).as("Status").isEqualTo(status);
    }

    public void hasComplete(boolean complete) {
        boolean actualComplete = actual.isComplete();
        softAssertions.assertThat(actualComplete).as("Complete").isEqualTo(complete);
    }

    public void isEqualTo(Order order) {
        hasId(order.getId());
        hasPetId(order.getPetId());
        hasQuantity(order.getQuantity());
        hasShipDate(order.getShipDate());
        hasStatus(order.getStatus());
        hasComplete(order.isComplete());
    }
}
