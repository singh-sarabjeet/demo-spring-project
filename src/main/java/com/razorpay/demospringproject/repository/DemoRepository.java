package com.razorpay.demospringproject.repository;

import com.razorpay.demospringproject.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sarabjeet.singh on 11/09/24
 */

@Repository
public interface DemoRepository extends JpaRepository<Payment, Long> {

}
