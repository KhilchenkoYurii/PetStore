package com.petstore.client.user;

import com.petstore.client.SetUp;
import com.petstore.models.User;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class UserServices extends SetUp {

    public UserServices() {
        super(UserPath.userUrl);
    }

    public Response createUser(User user) {
        return given(createRequest())
                .body(user)
                .post();
    }

    public Response loginUser(User user) {
        return given(createRequest())
                .get(UserPath.userLoginUrl + user.getUsername()+"&password=" + user.getPassword());
    }

    public Response logoutUser(User user) {
        return given(createRequest())
                .get(UserPath.userLogoutUrl);
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
