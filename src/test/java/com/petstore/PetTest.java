package com.petstore;

import com.petstore.assertion.petAssertions.PetAssertion;
import com.petstore.business.PetBL.PetBL;
import com.petstore.client.pet.PetServices;
import com.petstore.models.Pet;
import com.petstore.models.PetStatus;
import io.restassured.response.Response;
import org.assertj.core.api.SoftAssertions;
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
        Response response = getPetByStatus(PetStatus.Avilable);
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
