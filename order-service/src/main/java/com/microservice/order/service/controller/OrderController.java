package com.microservice.order.service.controller;

import com.microservice.order.service.common.TransactionRequest;
import com.microservice.order.service.common.TransactionResponse;
import com.microservice.order.service.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/order/")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping(value = "/place")
    public ResponseEntity<TransactionResponse> placeOrder(@RequestBody TransactionRequest transactionRequest) {
        TransactionResponse transactionResponse = orderService.saveOrder(transactionRequest);
        return ResponseEntity.ok(transactionResponse);
    }
}
