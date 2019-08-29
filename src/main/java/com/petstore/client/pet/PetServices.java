package com.petstore.client.pet;

import com.petstore.client.SetUp;
import com.petstore.models.Pet;
import com.petstore.models.PetStatus;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PetServices  extends SetUp {

    public PetServices() {

        super(PetPath.petUrl);
    }

    public Response addNewPet (Pet pet) {
        return given(createRequest())
                .body(pet)
                .post();
    }

    public Response getPetById(int id) {
        return given(createRequest())
                .get("" + id);
    }

    public Response getPetByStatus(PetStatus status) {
        return given(createRequest())
                .get(PetPath.petFindByStatusPath + status.toString());
    }

    public  Response updatePet(Pet pet) {
        return given(createRequest())
                .body(pet)
                .put();
    }

    public Response deletePet(int id) {
        return given(createRequest())
                .delete("" + id);
    }

    public Response petPostUploadImage(String id) {
        File file = new File("C:\\Users\\Максим\\Downloads\\testIMG.jpg");
        return given(createRequest())
                .pathParam("id",id)
                .contentType("multipart/form-data")
                .multiPart(file)
                .post("/{id}/uploadImage");
    }
}
