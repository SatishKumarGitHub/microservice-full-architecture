package com.microservice.order.service.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Payment {

    private int paymentId;
    private String status;
    private String transactionId;
    private PaymentType type;
    private int orderId;
    private double amount;


}
