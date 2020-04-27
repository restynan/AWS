package com.example.awslambda.service;

import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.S3Event;

public class LambdaWithS3 implements RequestHandler<S3Event,String> {
    private AmazonS3 s3  = AmazonS3ClientBuilder.standard().build();
    private final static String DESTINATION_BUCKET_NAME = "destinationbucket12";
    @Override
    public String handleRequest(S3Event s3Event, Context context) {






        return null;
    }
}
