package com.petstore.utilities;

import lombok.Getter;

@Getter
public enum StatusCodes {

    Success(200),
    InputError(400),
    NotFoundError(404),
    ServerError(500);

    private int value;

    StatusCodes(int value) {
        this.value = value;
    }

}
