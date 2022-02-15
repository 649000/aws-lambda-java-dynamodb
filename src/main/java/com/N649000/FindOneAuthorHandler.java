package com.N649000;

import com.N649000.models.Author;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import org.apache.http.HttpStatus;

import java.util.HashMap;

public class FindOneAuthorHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private Regions REGION = Regions.AP_SOUTHEAST_1;

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent requestEvent, Context context) {
        Gson gson = new Gson();
        LambdaLogger logger = context.getLogger();
        logger.log("APIGatewayProxyRequestEvent::" + requestEvent.toString());
        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(REGION)
                .build();

        final String id = requestEvent.getPathParameters().get("id");

        DynamoDBMapper mapper = new DynamoDBMapper(client);
        Author author = mapper.load(Author.class, id);
        System.out.println("Author retrieved:");
        System.out.println(author);

        responseEvent.setStatusCode(HttpStatus.SC_OK);
        responseEvent.setBody(gson.toJson(author));
        HashMap<String, String> header = new HashMap<>();
        header.put("content-type","application/json");
        responseEvent.setHeaders(header);
        return responseEvent;
    }
}
