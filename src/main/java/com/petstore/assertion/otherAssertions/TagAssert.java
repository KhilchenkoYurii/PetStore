package com.petstore.assertion.otherAssertions;

import com.petstore.models.Tag;
import org.assertj.core.api.SoftAssertions;

public class TagAssert {
    SoftAssertions softAssertions = new SoftAssertions();
    private static Tag actual;

    public  static TagAssert assertThat(Tag tag) {
        actual = tag;
        return new TagAssert();
    }

    public void hasId(int id) {
        int actualId = actual.getId();
        softAssertions.assertThat(actualId).as("Id").isEqualTo(id);
    }

    public void hasName(String name) {
        String actualName = actual.getName();
        softAssertions.assertThat(actualName).as("Name").isEqualTo(name);
    }

    public void isEqualTo(Tag tag) {
        hasId(tag.getId());
        hasName(tag.getName());
    }
}
