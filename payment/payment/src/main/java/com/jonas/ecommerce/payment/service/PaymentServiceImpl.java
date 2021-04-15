package com.jonas.ecommerce.payment.service;

import java.util.Optional;
import java.util.UUID;

import com.jonas.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.jonas.ecommerce.payment.entity.PaymentEntity;
import com.jonas.ecommerce.payment.repository.PaymentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final PaymentRepository paymentRepository;

    @Override
    public Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent){
        final PaymentEntity paymentEntity = PaymentEntity.builder()
            .checkoutCode(checkoutCreatedEvent.getCheckoutCode())
            .code(UUID.randomUUID().toString())
            .build();
            paymentRepository.save(paymentEntity);
            return Optional.of(paymentEntity);
    }

    @Autowired
    public PaymentServiceImpl(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }
}
