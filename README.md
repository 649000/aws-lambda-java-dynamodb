# AWS Lambda function with DynamoDB

## Overview 
This repository functions as a proof of concept (POC) illustrating the development of a serverless function by harnessing a range of AWS services. Absent AWS CDK or AWS SAM, it highlights the foundational establishment and operation of a serverless architecture exclusively using AWS services. The absence of these frameworks necessitates a manual deployment and configuration process, allowing for a deeper understanding of the underlying AWS components.

## Configuration in AWS Console
1. Deployment of Lambda functions
2. Providing required DynamoDB permissions via IAM
3. Creation of API Gateway
4. Creation of integration between API Gateway and Lambda

## Project Status

|Feature|Status  |
|--|--|
|CRUD on models|Completed  |
|Display results in JSON API| Completed
| Deployed on AWS| Completed


## Reflection
In today's business landscape, cloud computing stands as an indispensable asset for numerous enterprises. This proof of concept served as my foray into exploring AWS's suite of serverless solutions.

The primary challenge encountered in crafting this proof of concept revolved around redefining the approach to application design. Building for the cloud demands a shift in mindset, emphasizing the effective and efficient utilization of cloud services in unison.

Navigating Java lambda functions proved to be a challenge due to the scarcity of available resources and guides in this domain.

The manual configuration and deployment processes via the AWS Management Console or web UI were both time-consuming and repetitive. To enhance efficiency, future iterations will explore the integration of automation tools such as AWS CDK, AWS SAM, or the Serverless Framework to streamline these configurations.

