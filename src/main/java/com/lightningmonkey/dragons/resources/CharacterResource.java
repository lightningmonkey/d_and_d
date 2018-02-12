package com.lightningmonkey.dragons.resources;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBQueryExpression;
import com.amazonaws.services.dynamodbv2.model.*;
import com.lightningmonkey.dragons.representations.CharacterDB;
//import com.lightningmonkey.dragons.representations.CharacterForm;


import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Path("/character")
@Produces(MediaType.APPLICATION_JSON)
public class CharacterResource {

    private final Validator validator;

    public CharacterResource(Validator validator) {
        this.validator = validator;
    }

    private ArrayList<String> checkViolations(CharacterDB characterDB){
        Set<ConstraintViolation<CharacterDB>> violations = validator.validate(characterDB);
        ArrayList<String> validationMessages = new ArrayList<String>();
        if (violations.size() > 0 ){
            for(ConstraintViolation<CharacterDB> violation: violations){
                validationMessages.add(violation.getPropertyPath().toString() + ":" + violation.getMessage());
            }
        }
        return validationMessages;
    }

    @POST
    public Response createCharacter(CharacterDB characterDB){

        ArrayList<String> validationMessages = checkViolations(characterDB);
        if(validationMessages.size() > 0){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(validationMessages)
                    .build();
        }

        AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new ProfileCredentialsProvider("personal"))
                .build();


        DynamoDBMapper mapper = new DynamoDBMapper(ddb);

        UUID uuid = UUID.randomUUID();
        String uuidString = uuid.toString();
        characterDB.setId(uuidString);
        mapper.save(characterDB);

        return Response.ok(characterDB.toString()).build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteCharacter(@PathParam("id") String id){
        return Response.noContent().build();
    }

    @PUT
    @Path("/{id}")
    public Response updateCharacter(@PathParam("id") String id,
                                    CharacterDB characterDB){
        ArrayList<String> validationMessages = checkViolations(characterDB);
        if(validationMessages.size() > 0){
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(validationMessages)
                    .build();
        }
        AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new ProfileCredentialsProvider("personal"))
                .build();


        DynamoDBMapper mapper = new DynamoDBMapper(ddb);
//        CharacterDB characterDB = new CharacterDB(characterForm);
        mapper.save(characterDB);

        return Response.ok(characterDB.toString()).build();
    }

    @GET
    @Path("/{id}")
    public Response getCharacter(@PathParam("id") String id) {

        CharacterDB Character = new CharacterDB();
        Character.setId(id);

        AmazonDynamoDB ddb = AmazonDynamoDBClientBuilder
                .standard()
                .withRegion(Regions.US_EAST_1)
                .withCredentials(new ProfileCredentialsProvider("personal"))
                .build();

        DynamoDBQueryExpression<CharacterDB> queryExpression = new DynamoDBQueryExpression<CharacterDB>()
                .withHashKeyValues(Character);

        DynamoDBMapper mapper = new DynamoDBMapper(ddb);

        List<CharacterDB> itemList = mapper.query(CharacterDB.class, queryExpression);
        return Response.ok(itemList.get(0)).build();
    }

}
