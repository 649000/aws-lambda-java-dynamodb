package com.N649000;


import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

public class CreateAuthorHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent requestEvent, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("APIGatewayProxyRequestEvent::" +requestEvent.toString());

        APIGatewayProxyResponseEvent responseEvent = new APIGatewayProxyResponseEvent();
        responseEvent.setBody(requestEvent.getBody());

        //Retrieves HTTP body
        logger.log("requestEvent.getBody()::" +requestEvent.getBody());

        JsonObject convertedObject = new Gson().fromJson(requestEvent.getBody(), JsonObject.class);
        responseEvent.setStatusCode(convertedObject.get("statusCode").getAsInt());
        responseEvent.setHeaders(requestEvent.getHeaders());
        responseEvent.setIsBase64Encoded(requestEvent.getIsBase64Encoded());
        return responseEvent;
    }
}
