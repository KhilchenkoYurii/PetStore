package com.petstore.assertion.petAssertions;

import com.petstore.models.Category;
import com.petstore.models.Pet;
import com.petstore.models.PetStatus;
import com.petstore.models.Tag;
import org.assertj.core.api.SoftAssertions;

public class PetAssertion {
    SoftAssertions softAssertions = new SoftAssertions();
    private static Pet actual;

    public static PetAssertion assertThat(Pet pet) {
        actual = pet;
        return new PetAssertion();
    }

    public void hasId(int id) {
        int actualId = actual.getId();
        softAssertions.assertThat(actualId).as("Id").isEqualTo(id);
    }

    public void hasCategory(Category category) {
        Category actualCategory = actual.getCategory();
        softAssertions.assertThat(actualCategory).as("Category").isEqualTo(category);
    }

    public void hasName(String name) {
        String actualName = actual.getName();
        softAssertions.assertThat(actualName).as("Name").isEqualTo(name);
    }

    public void hasPhotosUrls(String photoUrls) {
        String actualPhotoUrls = actual.getPhotoUrls();
        softAssertions.assertThat(actualPhotoUrls).as("PhotoUrls").isEqualTo(photoUrls);
    }

    public void hasTag(Tag tag) {
        Tag actualTag = actual.getTags();
        softAssertions.assertThat(actualTag).as("Tag").isEqualTo(tag);
    }

    public void hasStatus(PetStatus status) {
        PetStatus actualStatus = actual.getStatus();
        softAssertions.assertThat(actualStatus).as("Status").isEqualTo(status);
    }

    public void isEqualTo(Pet pet) {
        hasCategory(pet.getCategory());
        hasId(pet.getId());
        hasName(pet.getName());
        hasPhotosUrls(pet.getPhotoUrls());
        hasTag(pet.getTags());
        hasStatus(pet.getStatus());
    }
}
