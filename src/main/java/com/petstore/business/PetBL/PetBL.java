package com.petstore.business.PetBL;

import com.petstore.client.pet.PetServices;
import com.petstore.models.Category;
import com.petstore.models.Pet;
import com.petstore.models.PetStatus;
import com.petstore.models.Tag;
import io.restassured.response.Response;
import org.apache.commons.lang3.RandomStringUtils;


public class PetBL {
    private int id = Integer.parseInt(RandomStringUtils.randomNumeric(3));
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
                .photoUrls(RandomStringUtils.randomAlphabetic(20))
                .tags(Tag.builder()
                        .id(id)
                        .name(name)
                        .build())
                .status(PetStatus.Avilable)
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
