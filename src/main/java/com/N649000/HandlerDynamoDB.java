package com.N649000;

import com.N649000.models.Author;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.DynamodbEvent;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;


public class HandlerDynamoDB implements RequestHandler<DynamodbEvent, String>{
    private DynamoDB dynamoDb;
    private String DYNAMODB_TABLE_NAME = System.getenv("TABLE_NAME");
    private Regions REGION = Regions.AP_SOUTHEAST_1;
    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    @Override
    public String handleRequest(DynamodbEvent event, Context context)
    {

        //This works
        LambdaLogger logger = context.getLogger();
//        Table table = initDynamoDbClient();
//
//        try {
//           logger.log("Adding a new item..");
//            PutItemOutcome outcome = table
//                    .putItem(new Item().withPrimaryKey("id", UUID.randomUUID().toString(), "lastName", "NAME2"));
//
//            logger.log("PutItem succeeded:\n" + outcome.getPutItemResult());
//
//        }
//        catch (Exception e) {
//            logger.log(e.getMessage());
//        }

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(REGION)
                .build();

        DynamoDBMapper mapper = new DynamoDBMapper(client);

        Author author = new Author();
        Date date = new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        author.setId(UUID.randomUUID().toString());
        author.setFirstName(timestamp2.toString());
        author.setLastName(timestamp2.toString());

        mapper.save(author);

        String response = new String("200 OK");

        return response;
    }

    private Table initDynamoDbClient() {
         dynamoDb = new DynamoDB(REGION);
         return dynamoDb.getTable(DYNAMODB_TABLE_NAME);
    }
}