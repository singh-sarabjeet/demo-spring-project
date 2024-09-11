package com.razorpay.demospringproject.service;

import com.razorpay.demospringproject.enums.PaymentStatus;
import com.razorpay.demospringproject.entity.Payment;
import com.razorpay.demospringproject.providers.cache.RedisStore;
import com.razorpay.demospringproject.repository.DemoRepository;
import com.razorpay.demospringproject.utils.Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @author sarabjeet.singh on 11/09/24
 */

@Service
@Slf4j
public class DemoService {

    private final DemoRepository repository;

    final RedisStore cache;

    public DemoService(DemoRepository repository, RedisStore cache) {
        this.repository = repository;
        this.cache = cache;
    }

    public String createDemoRecords() {
        Payment payment = new Payment();
        payment.setId(Util.generateRandomId());
        payment.setAmount(Util.generateRandomAmount());
        payment.setPurpose("Demo payment record");
        payment.setStatus(PaymentStatus.INITIATED);

        String id = repository.save(payment).getId();
        log.info("Payment successfully saved in DB with id: {}", id);

        cache.setValue(String.valueOf(id), payment.toString());
        log.info("Payment successfully saved in cache with id: {}", id);
        return id;
    }

    public Payment getPayment(String id){
        // retrieve payment from cache and log it
        String payment = cache.getValue(id);
        log.info("Payment found in cache: {}", payment);

        Optional<Payment> optionalPayment = repository.findById(Long.valueOf(id));
        if (optionalPayment.isPresent()){
            log.info("Payment found in DB for id: {}", id);
            return optionalPayment.get();
        }else{
            log.info("Payment not found in DB for id: {}", id);
            return null;
        }
    }
}
