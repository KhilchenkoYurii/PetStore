package com.petstore.business.UserBL;

import com.petstore.client.user.UserServices;
import com.petstore.models.User;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;

public class UserBL {
    private int randomInt = Integer.parseInt(RandomStringUtils.randomNumeric(5));
    private  String randomString = RandomStringUtils.randomAlphabetic(10);

    public User createUser() {
        User newUser = User.builder()
                .id(randomInt)
                .username(randomString)
                .firstName(randomString)
                .lastName(randomString)
                .email(randomString)
                .password(randomString)
                .phone(randomString)
                .userStatus(randomInt)
                .build();
        return newUser;
    }

    public User userfromJson(String username) {
        Response response = new UserServices().getUserByUsername(username);
        User user = response.as(User.class);
        return user;
    }

    public User doUpdate(String username) {
        User oldUser = userfromJson(username);
        oldUser.setPhone(randomString);
        oldUser.setUserStatus(randomInt);
        oldUser.setEmail(randomString);
        return oldUser;
    }
 }
