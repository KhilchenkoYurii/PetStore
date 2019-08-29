package com.petstore;

import com.petstore.assertion.petAssertions.PetAssertion;
import com.petstore.assertion.userAssertions.UserAssertion;
import com.petstore.business.UserBL.UserBL;
import com.petstore.client.user.UserServices;
import com.petstore.models.User;
import io.restassured.response.Response;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTest extends UserServices {
    private static User testStaticUser;
    private User testUser;

    @BeforeClass
    public void setUp() {
        testStaticUser = new UserBL().createUser();
    }

    @Test(priority = 1)
    public void addNewUserTest() {
        Response response = createUser(testStaticUser);
        System.out.println(response.toString());
        User newUser = new UserBL().createUser();
        UserAssertion.assertThat(response.getBody().as(User.class)).isEqualTo(newUser);
    }

    @Test(priority = 2)
    public void loginUserTest() {
        Response response = loginUser(testStaticUser);
        AssertJUnit.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 3)
    public void logoutUserTest() {
        Response response = logoutUser(testStaticUser);
        AssertJUnit.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 4)
    public void getUserByUsernameTest() {
        Response response = getUserByUsername(testStaticUser.getUsername());
        AssertJUnit.assertEquals(200,response.getStatusCode());
    }

    @Test(priority = 5)
    public void updateUserTest() {
        testUser = new UserBL().doUpdate(testStaticUser.getUsername());
        Response response = updateUser(testStaticUser.getUsername(),testStaticUser);
        UserAssertion.assertThat(response.getBody().as(User.class))
                .hasId(testUser.getId());
    }

    @Test(priority = 6)
    public void deleteUserTest() {
        Response response = deleteUser(testStaticUser.getUsername());
        AssertJUnit.assertEquals(200,response.getStatusCode());
    }
}
