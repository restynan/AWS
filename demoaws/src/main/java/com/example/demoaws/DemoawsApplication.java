package com.example.demoaws;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class DemoawsApplication {
    @Value("${access.key}")
   private static String accesskey;
    @Value("${secret.key}")
    private static String secretkey;

    public static void main(String[] args) {
        SpringApplication.run(DemoawsApplication.class, args);


      //  final AmazonS3 s3 =AmazonS3ClientBuilder.standard().build();

        BasicAWSCredentials cred= new BasicAWSCredentials("AKIAXXBMI6WTYYQCZUG6","qNkFyF8tX+0rICPCxepgY/S7C16lyA8Axn3Q8h2n");
        AmazonS3 s3 =AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(cred)).build();


       List<Bucket> buckets=s3.listBuckets();
        buckets.stream().forEach(bucket->{

            System.out.println("Bucket Name: "+bucket.getName() +", Bucket owner:  "+bucket.getOwner().getDisplayName()+
                        " ,Bucket creation date:  "+bucket.getCreationDate());
                }



                );



    }

}
