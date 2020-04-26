package com.example.demoaws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;


import com.amazonaws.services.s3.model.S3Object;
import com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.example.demoaws.models.DemoUser;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;


@SpringBootApplication
public class DemoawsApplication {

    private static Logger logger = LoggerFactory.getLogger(DemoawsApplication.class);
    private static String SOURCE_BUCKET_NAME = "testdemo13";


    public static void main(String[] args) {
        SpringApplication.run(DemoawsApplication.class, args);


        //  final AmazonS3 s3 =AmazonS3ClientBuilder.standard().build();

        BasicAWSCredentials cred = new BasicAWSCredentials("AKIAXXBMI6WTYWZX444R", "TOnO0me/DkouRA2ABPARLasCTdeNKqbh2qDroYak");
        AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).build();

        //Listing all buckets
        List<Bucket> buckets = s3.listBuckets();

        //geting content from bucket
        S3Object object = s3.getObject(SOURCE_BUCKET_NAME, "userDemo.txt");
        S3ObjectInputStream stream = object.getObjectContent();
        ObjectMapper mapper = new ObjectMapper();
        try {
            DemoUser user = mapper.readValue(stream, DemoUser.class);
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();

        }


        //interating through the bucket
        logger.info("printing bucket details");
        buckets.stream().forEach(bucket -> {

                    logger.info("Bucket Name: " + bucket.getName() + ", Bucket owner:  " + bucket.getOwner().getDisplayName() +
                            " ,Bucket creation date:  " + bucket.getCreationDate());
                }


        );


    }

}
