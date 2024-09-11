package com.razorpay.demospringproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@EnableCaching
@SpringBootApplication
public class DemoSpringProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoSpringProjectApplication.class, args);
    }

}
