package com.petstore.client;

import com.petstore.models.Pet;
import io.restassured.response.Response;

import java.io.File;

import static io.restassured.RestAssured.given;

public class PetServices  extends SetUp {

    public PetServices() {

        super(Paths.petUrl);
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

    public Response getPetByStatus(String status) {
        return given(createRequest())
                .get(Paths.petFindByStatusPath + status);
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

    public Response petPostUploadImage(int id) {
        File file = new File("C:\\Users\\gembi\\Desktop\\SoftServ IT Academy\\unnamed.png");
        return given(createRequest())
                .pathParam("id",id)
                .contentType("multipart/form-data")
                .multiPart(file)
                .post("/{id}/uploadImage");
    }
}
