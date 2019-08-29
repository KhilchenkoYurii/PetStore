package com.petstore.business;

import com.petstore.client.PetServices;
import com.petstore.models.Category;
import com.petstore.models.Pet;
import com.petstore.models.Status;
import com.petstore.models.Tag;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.Collections;


public class PetBL {
    private int id = Integer.parseInt(RandomStringUtils.randomNumeric(2));
    private String name = RandomStringUtils.randomAlphabetic(7);
    private Pet pet;

    public Pet createPet() {
        pet = Pet.builder()
                .id(id)
                .category(Category.builder()
                            .id(id)
                            .name(name)
                            .build())
                .name(name)
                .photoUrls(Collections.singletonList(RandomStringUtils.randomAlphabetic(10)))
                .tags(Collections.singletonList(Tag.builder()
                        .id(id)
                        .name(name)
                        .build()))
                .status(Status.Available.getValue())
                .build();
        return pet;
    }

    public Pet petFromJson(int id) {
        Response response = new PetServices().getPetById(id);
        Pet newPet = response.as(Pet.class);
        return newPet;
    }

    public Pet doUpdate(int id){
        Pet oldPet = petFromJson(id);
        oldPet.setName(RandomStringUtils.randomAlphabetic(8));
        oldPet.setCategory(new Category(id, name));
        return oldPet;

    }
}
