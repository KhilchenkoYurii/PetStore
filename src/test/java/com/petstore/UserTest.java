package com.petstore;

import com.petstore.assertion.StatusCodeAssertion;
import com.petstore.utilities.StatusCodes;
import com.petstore.assertion.UserAssertion;
import com.petstore.business.UserBL;
import com.petstore.client.UserServices;
import com.petstore.models.User;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class UserTest extends UserServices {
    private static User testStaticUser =  new UserBL().createUser();
    private User testUser;
    private Response response;

    @Test
    public void addNewUserTest() {
        response = createUser(testStaticUser);
        User newUser = new UserBL().createUser();
        UserAssertion.assertThat(response.getBody().as(User.class)).isEqualTo(newUser);
    }

    @Test
    public void loginUserTest() {
        response = loginUser(testStaticUser);
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.Success.getValue());
    }

    @Test
    public void logoutUserTest() {
        response = logoutUser(testStaticUser);
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.Success.getValue());
    }

    @Test
    public void getUserByUsernameTest() {
        response = getUserByUsername(testStaticUser.getUsername());
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.Success.getValue());
    }

    @Test
    public void updateUserTest() {
        testUser = new UserBL().doUpdate(testStaticUser.getUsername());
        response = updateUser(testStaticUser.getUsername(),testStaticUser);
        UserAssertion.assertThat(response.getBody().as(User.class))
                .hasId(testUser.getId());
    }

    @Test
    public void deleteUserTest() {
        response = deleteUser(testStaticUser.getUsername());
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.Success.getValue());
    }
}
