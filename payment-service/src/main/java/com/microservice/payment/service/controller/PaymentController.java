package com.microservice.payment.service.controller;

import com.microservice.payment.service.entity.Payment;
import com.microservice.payment.service.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/payment/")
public class PaymentController {

    private PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping(value = "/make-payment")
    public ResponseEntity<Payment> doPayment(@RequestBody Payment payment) {

        payment = paymentService.doPayment(payment);
        return ResponseEntity.ok(payment);
    }

    @GetMapping(value = "/history/{orderId}")
    public ResponseEntity<Payment> getPaymentHistory(@PathVariable("orderId") int orderId) {
        Payment paymentHistory = paymentService.getPaymentHistory(orderId);
        return ResponseEntity.ok(paymentHistory);
    }


}
