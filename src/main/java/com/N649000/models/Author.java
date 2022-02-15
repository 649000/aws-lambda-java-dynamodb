package com.N649000.models;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@DynamoDBTable(tableName="author")
public class Author {

    @DynamoDBHashKey
    private String id;
    @DynamoDBAttribute
    private String firstName;
    @DynamoDBAttribute
    private String lastName;
}