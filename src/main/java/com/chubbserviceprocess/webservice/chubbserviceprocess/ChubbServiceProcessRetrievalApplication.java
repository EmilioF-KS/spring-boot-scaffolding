package com.chubbserviceprocess.webservice.chubbserviceprocess;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.chubbserviceprocess.webservice"})
public class ChubbServiceProcessRetrievalApplication {
    public static void main(String[] args) {
        SpringApplication.run(ChubbServiceProcessRetrievalApplication.class, args);
    }
}


