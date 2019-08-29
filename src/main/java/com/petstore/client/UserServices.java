package com.petstore.client;

import com.petstore.utilities.Paths;
import com.petstore.models.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserServices extends SetUp {

    public UserServices() {
        super(Paths.userUrl);
    }

    public Response createUser(User user) {
        return given(createRequest())
                .body(user)
                .post();
    }

    public Response loginUser(User user) {
        return given(createRequest())
                .get(Paths.userLoginUrl + user.getUsername()+"&password=" + user.getPassword());
    }

    public Response logoutUser(User user) {
        return given(createRequest())
                .get(Paths.userLogoutUrl);
    }

    public Response getUserByUsername(String username) {
        return given(createRequest())
                .get("" + username);
    }

    public Response updateUser(String username, User user) {
        return given(createRequest())
                .body(user)
                .put("" + username);
    }

    public  Response deleteUser(String username) {
        return given(createRequest())
                .delete("" + username);
    }
}
