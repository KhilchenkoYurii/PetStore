package com.petstore.assertion;

import com.petstore.models.User;
import org.assertj.core.api.SoftAssertions;

public class UserAssertion {
    SoftAssertions softAssertions = new SoftAssertions();
    private static User actual;

    public static UserAssertion assertThat(User user) {
        actual = user;
        return new UserAssertion();
    }

    public void hasId(int id) {
        int actualId = actual.getId();
        softAssertions.assertThat(actualId).as("Id").isEqualTo(id);
    }

    public void hasUsername(String username) {
        String actualUsername = actual.getUsername();
        softAssertions.assertThat(actualUsername).as("Username").isEqualTo(username);
    }

    public void hasFirsname(String firstname) {
        String actualFirstname = actual.getFirstName();
        softAssertions.assertThat(actualFirstname).as("Firstname").isEqualTo(firstname);
    }

    public void hasLastname(String lastname) {
        String actualLastname = actual.getLastName();
        softAssertions.assertThat(actualLastname).as("Lastname").isEqualTo(lastname);
    }

    public void hasEmail(String email) {
        String actualEmail = actual.getEmail();
        softAssertions.assertThat(actualEmail).as("Email").isEqualTo(email);
    }

    public void hasPassword(String password) {
        String actualPassword = actual.getPassword();
        softAssertions.assertThat(actualPassword).as("Password").isEqualTo(password);
    }

    public void hasPhone(String phone) {
        String actualPhone = actual.getPhone();
        softAssertions.assertThat(actualPhone).as("Phone").isEqualTo(phone);
    }

    public void hasStatus(int status) {
        int actualStatus = actual.getUserStatus();
        softAssertions.assertThat(actualStatus).as("UserStatus").isEqualTo(status);
    }

    public void isEqualTo(User user) {
        hasId(user.getId());
        hasFirsname(user.getFirstName());
        hasLastname(user.getLastName());
        hasEmail(user.getEmail());
        hasPassword(user.getPassword());
        hasPhone(user.getPhone());
        hasStatus(user.getUserStatus());
    }
}
