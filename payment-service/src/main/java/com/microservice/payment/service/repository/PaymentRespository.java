package com.microservice.payment.service.repository;

import com.microservice.payment.service.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRespository extends JpaRepository<Payment, Integer> {

    Optional<Payment> findByOrderId(int orderId);
}
