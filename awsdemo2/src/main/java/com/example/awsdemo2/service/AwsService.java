package com.example.awsdemo2.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.List;
@Service
public class AwsService {
    Logger logger = LoggerFactory.getLogger(AwsService.class);
    private AmazonS3 s3;
@PostConstruct
    public void init(){
    s3 = AmazonS3ClientBuilder.standard().build();
    }

    public List<Bucket> getListofBukets(){
    return s3.listBuckets();
    }
//geting content from bucket
    public S3Object getContentfromBuket(String bucketName,String filename ){
        S3Object object = s3.getObject(bucketName, filename);
        return  object;

    }
    //creating a bucket
    public  Bucket createBucket(String bucketName){
   return s3.createBucket(bucketName);

    }

}
