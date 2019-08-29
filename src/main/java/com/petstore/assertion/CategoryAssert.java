package com.petstore.assertion;


import com.petstore.models.Category;
import org.assertj.core.api.SoftAssertions;

public class CategoryAssert {
    SoftAssertions softAssertions = new SoftAssertions();
    private static Category actual;

    public static CategoryAssert assertThat(Category category) {
        actual = category;
        return new CategoryAssert();
    }

    public void hasId(int id) {
        int actualId = actual.getId();
        softAssertions.assertThat(actualId).as("id").isEqualTo(id);
    }

    public void hasName(String name) {
        String actualName = actual.getName();
        softAssertions.assertThat(actualName).as("Name").isEqualTo(name);
    }

    public void isEqualTo(Category category) {
        hasId(category.getId());
        hasName(category.getName());
    }
}
