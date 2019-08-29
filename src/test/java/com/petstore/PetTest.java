package com.petstore;

import com.petstore.assertion.PetAssertion;
import com.petstore.assertion.StatusCodeAssertion;
import com.petstore.business.PetBL;
import com.petstore.client.PetServices;
import com.petstore.models.Pet;
import com.petstore.utilities.StatusCodes;
import io.restassured.response.Response;
import org.testng.annotations.Test;

public class PetTest extends PetServices {

    private static Pet testStatPet = new PetBL().createPet();
    private Pet testPet;
    private Response response;

    @Test(priority = 1)
    public void addNewPetTest() {
        response = addNewPet(testStatPet);
        Pet newPet = new PetBL().createPet();
        PetAssertion.assertThat(response.getBody().as(Pet.class)).isEqualTo(newPet);
    }

    @Test(priority = 2)
    public void getPetByIdTest() {
        response = getPetById(testStatPet.getId());
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.Success.getValue());
    }

    @Test(priority = 3)
    public void getPetByStatus() {
        response = getPetByStatus("available");
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.Success.getValue());
    }

    @Test(priority = 4)
    public void uploadImageTest() {
        response = petPostUploadImage(testStatPet.getId());
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.Success.getValue());
    }

    @Test(priority = 5)
    public void updatePetTest() {
        testPet = new PetBL().doUpdate(testStatPet.getId());
        response = updatePet(testStatPet);
        PetAssertion.assertThat(response.getBody().as(Pet.class))
                .hasId(testPet.getId());

    }

    @Test(priority = 6)
    public void deletePetTest() {
        Response response = deletePet(testStatPet.getId());
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.Success.getValue());
    }

    /*@Test(priority = 7)
    public void addNewPetTestNeg() {
        response = addNewPet(null);
        Pet newPet = new PetBL().createPet();
        PetAssertion.assertThat(response.getBody().as(Pet.class)).isEqualTo(newPet);
    }   */

    @Test(priority = 8)
    public void getPetByIdTestNeg() {
        response = getPetById(testStatPet.getId());
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.NotFoundError.getValue());
    }

    @Test(priority = 12)
    public void deletePetTestNeg() {
        Response response = deletePet(testStatPet.getId());
        StatusCodeAssertion.statusCodeAssert( response, StatusCodes.NotFoundError.getValue());
    }


}
