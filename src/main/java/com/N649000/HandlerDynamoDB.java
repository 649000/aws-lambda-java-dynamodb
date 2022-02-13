package com.N649000;

import com.N649000.models.Author;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

//Input and Output definition
public class HandlerDynamoDB implements RequestHandler<Author, String> {
    private Regions REGION = Regions.AP_SOUTHEAST_1;

    @Override
    public String handleRequest(Author input, Context context) {

        LambdaLogger logger = context.getLogger();
        logger.log(input.toString());
        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(REGION)
                .build();

        DynamoDBMapper mapper = new DynamoDBMapper(client);

//        Author author = new Author();
//        Date date = new Date();
//        Timestamp timestamp2 = new Timestamp(date.getTime());
//        author.setId(UUID.randomUUID().toString());
//        author.setFirstName(timestamp2.toString());
//        author.setLastName(timestamp2.toString());
//        logger.log("Adding a new item..");
//        mapper.save(author);

        mapper.save(input);

        return "200 OK";
    }
}