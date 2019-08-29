package com.petstore.models;

import lombok.Getter;

@Getter
public enum Status {
    Available("available"),
    Pending("pending"),
    Sold("sold"),
    Placed("placed"),
    Approved("approved"),
    Delivered("delivered");

    private String value;

    Status(String value) {
        this.value = value;
    }
}
