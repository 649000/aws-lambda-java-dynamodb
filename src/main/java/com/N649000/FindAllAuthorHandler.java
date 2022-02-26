package com.N649000;

import com.N649000.models.Author;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.List;

public class FindAllAuthorHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    private Regions REGION = Regions.AP_SOUTHEAST_1;

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent requestEvent, Context context) {
        Gson gson = new Gson();
        LambdaLogger logger = context.getLogger();
        logger.log("APIGatewayProxyRequestEvent::" + requestEvent.toString());

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withRegion(REGION)
                .build();
        DynamoDBMapper mapper = new DynamoDBMapper(client);

        DynamoDBScanExpression scanExp = new DynamoDBScanExpression();

        List<Author> results = mapper.scan(Author.class, scanExp);

        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setStatusCode(HttpStatus.SC_OK);
        responseEvent.setBody(gson.toJson(results));
        HashMap<String, String> header = new HashMap<>();
        header.put(HttpHeaders.CONTENT_TYPE,"application/json");
        responseEvent.setHeaders(header);
        return responseEvent;
    }
}
