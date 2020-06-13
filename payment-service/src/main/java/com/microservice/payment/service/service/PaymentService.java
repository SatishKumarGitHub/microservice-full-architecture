package com.microservice.payment.service.service;

import com.microservice.payment.service.entity.Payment;
import com.microservice.payment.service.repository.PaymentRespository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.UUID;

@Service
public class PaymentService {

    private PaymentRespository paymentRespository;

    public PaymentService(PaymentRespository paymentRespository) {
        this.paymentRespository = paymentRespository;
    }

    public Payment doPayment(Payment payment) {
        payment.setStatus(paymentProcessing());
        payment.setTransactionId(UUID.randomUUID().toString());
        return paymentRespository.save(payment);
    }

    public String paymentProcessing() {
        return new Random().nextBoolean() ? "success" : "failed";
    }

    public Payment getPaymentHistory(int orderId) {
        return paymentRespository.findByOrderId(orderId).
                orElseThrow(() -> new IllegalArgumentException("This OrderId {} does not exist " + orderId));
    }
}
