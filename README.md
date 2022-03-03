# aws-lambda-java-dynamodb
AWS Lambda function with DynamoDB Proof of Concept

This repo contains proof of concept for creating a serverless JSON API using AWS services

This serverless API does not use AWS CDK or AWS SAM.

It only contains the handler functions for lambda. Manually deployment and configuration is still required via the AWS Management Console

Configuration needed to be done in AWS Console
1. Deployment of Lambda functions
2. Providing required dynamoDB permissions via IAM
3. Creation of API Gateway
4. Creation of integration between API Gateway and Lambda

Future improvements include exploring of AWS CDK, AWS SAM or Serverless Framework to automate the abovementioned configuration.
