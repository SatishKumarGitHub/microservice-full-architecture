package com.microservice.order.service.service;

import com.microservice.order.service.common.Payment;
import com.microservice.order.service.common.TransactionRequest;
import com.microservice.order.service.common.TransactionResponse;
import com.microservice.order.service.entity.Order;
import com.microservice.order.service.repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
@Slf4j
@RefreshScope
public class OrderService {

    private OrderRepository orderRepository;

    @Lazy
    private RestTemplate restTemplate;

    @Value("${microservice.payment-service.endpoints.endpoint.uri}")
    public String PAYMENT_SERVICE_URL;


    public OrderService(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public TransactionResponse saveOrder(TransactionRequest transactionRequest) {
        Order order = transactionRequest.getOrder();
        Payment payment = transactionRequest.getPayment();
        payment.setOrderId(order.getId());
        payment.setAmount(order.getPrice());
        Payment paymentResponse = restTemplate.
                postForObject(PAYMENT_SERVICE_URL, payment, Payment.class);
        String response = paymentResponse.getStatus().equals("success") ? "Payment Processed Successfully" : "Payment failed order has been added into cart";
        orderRepository.save(order);
        return new TransactionResponse(order, paymentResponse.getAmount(), paymentResponse.getTransactionId(), response);
    }
}
