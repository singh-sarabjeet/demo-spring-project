package com.razorpay.demospringproject.entity;

import com.razorpay.demospringproject.enums.PaymentStatus;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;

/**
 * @author sarabjeet.singh on 11/09/24
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "amount", nullable = false)
    private int amount;

    @Column(name = "purpose")
    private String purpose;

    @Column(name = "status")
    private PaymentStatus status;

    @Column(name = "created_at", nullable = false)
    protected Long createdAt;

    @Column(name = "updated_at", nullable = false)
    protected Long updatedAt = Instant.now().toEpochMilli();

    @Column(name = "is_deleted")
    protected Boolean isDeleted = Boolean.FALSE;

}
