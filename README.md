# AWS Lambda function with DynamoDB Proof of Concept

This repo contains proof of concept for creating a serverless JSON API using AWS services

This serverless API does not use AWS CDK or AWS SAM.

It only contains the handler functions for lambda. Manually deployment and configuration is still required via the AWS Management Console

## Configuration in AWS Console
1. Deployment of Lambda functions
2. Providing required dynamoDB permissions via IAM
3. Creation of API Gateway
4. Creation of integration between API Gateway and Lambda

## Project Status

|Feature|Status  |
|--|--|
|CRUD on models|Completed  |
|Display results in JSON API| Completed
| Deployed on AWS| Completed


## Reflection
Cloud computing has become a mainstay for many firms. In this proof of concept, I wanted to explore the serverless offerings from AWS. 

The challenge in creating this proof of concept was having a different approach to application design. When designing for the cloud, one has to think in terms of services and use them effectively (and efficiently) together. 

There are not many resources on Java lambda so it can be difficult to find guides on it. 

Using the AWS management console/web UI to handle the deployments and setting of permissions can be tedious and repetitive. Future improvements include exploring AWS CDK, AWS SAM or Serverless Framework to automate such configurations.

#### Tools used
1. Postman  - to test the endpoints
2. Intellij IDE
