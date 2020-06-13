package com.microservice.api.gateway.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

    @RequestMapping("/order-service-fallback")
    public Mono<String> orderServiceFallback() {

        return Mono.just("Order Service is taking too long to respond or is down, please try again later");
    }


    @RequestMapping("/payment-service-fallback")
    public Mono<String> payementServiceFallback() {

        return Mono.just("Payment Service is taking too long to respond or is down, please try again later");

    }


}
