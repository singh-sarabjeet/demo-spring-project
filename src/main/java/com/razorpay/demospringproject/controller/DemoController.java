package com.razorpay.demospringproject.controller;

import com.razorpay.demospringproject.entity.Payment;
import com.razorpay.demospringproject.service.DemoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author sarabjeet.singh on 11/09/24
 */
@RestController
@RequestMapping("/api")
@Slf4j
public class DemoController {

    private final DemoService demoService;

    public DemoController(DemoService demoService) {
        this.demoService = demoService;
    }

    @PostMapping("/payment/create/")
    public ResponseEntity<String> createDataRecords(){
        try {
            String id = demoService.createDemoRecords();
            return new ResponseEntity<>("Payment id: " + id, HttpStatus.CREATED);
        }catch (Exception e){
            log.error("Exception occurred while execution");
            return new ResponseEntity<>("Error occurred while creating the records",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping ("/payment/{paymentId}")
    public ResponseEntity<String> getPayment(@PathVariable String paymentId){
        try {
            Payment payment = demoService.getPayment(paymentId);
            return new ResponseEntity<>("Payment: {}" + payment, HttpStatus.OK);
        }catch (Exception e){
            log.error("Exception occurred while execution");
            return new ResponseEntity<>("Error occurred while fetching the records",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
