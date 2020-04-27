package com.example.awsdemo2.controller;

import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.S3Object;
import com.example.awsdemo2.service.AwsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home")
public class HomeController {
    @Autowired
    AwsService awsService;

    @GetMapping("/")
        public String home(){

        return "Welcome home Resty";
        }

    @GetMapping("/listbuckets")
    public List<Bucket> getListofBukets(){
        return     awsService.getListofBukets();

    }

    //geting content from bucket
    @GetMapping("/getS3object")
    public S3Object getContentfromBuket( @RequestParam String bucketName, @RequestParam String filename ){

        return  awsService.getContentfromBuket(bucketName,filename );

    }
    //creating a bucket

    @GetMapping("/createbucket")
    public  Bucket createBucket(@RequestParam  String bucketName){
        return awsService.createBucket(bucketName);

    }
}
