package com.petstore;

import com.petstore.assertion.PetAssertion;
import com.petstore.business.PetBL;
import com.petstore.client.PetServices;
import com.petstore.models.Pet;
import io.restassured.response.Response;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class PetTest extends PetServices {
    private static Pet testStatPet;
    private Pet testPet;

    @BeforeClass
    public static void setUp() {
        testStatPet = new PetBL().createPet();
    }

    @Test(priority = 1)
    public void addNewPetTest() {
        Response response = addNewPet(testStatPet);
        Pet newPet = new PetBL().createPet();
        PetAssertion.assertThat(response.getBody().as(Pet.class)).isEqualTo(newPet);
    }

    @Test (priority = 2)
    public void getPetByIdTest() {
        Response response = getPetById(testStatPet.getId());
        AssertJUnit.assertEquals(200, response.getStatusCode());
    }

    @Test(priority = 5)
    public void getPetByStatus() {
        Response response = getPetByStatus("available");
        AssertJUnit.assertEquals(200, response.getStatusCode());
    }

    @Test
    public void uploadImageTest() {
        Response response = petPostUploadImage(testStatPet.getId());
        AssertJUnit.assertEquals(200, response.getStatusCode());
    }

    @Test(priority = 3)
    public void updatePetTest() {
        testPet = new PetBL().doUpdate(testStatPet.getId());
        Response response = updatePet(testStatPet);
        PetAssertion.assertThat(response.getBody().as(Pet.class))
                .hasId(testPet.getId());

    }

    @Test(priority = 4)
    public void deletePetTest() {
        Response response = deletePet(testStatPet.getId());
        AssertJUnit.assertEquals(200,response.getStatusCode());
    }
}
