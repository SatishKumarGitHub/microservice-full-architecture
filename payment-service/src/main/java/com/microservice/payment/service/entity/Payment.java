package com.microservice.payment.service.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "PAYMENT_TBL")
public class Payment implements Serializable {

    @Id
    @GeneratedValue
    private int paymentId;
    private String status;
    private String transactionId;
    @Enumerated(EnumType.STRING)
    private PaymentType type;
    private int orderId;
    private double amount;


}
