package com.jonas.ecommerce.payment.service;

import java.util.Optional;

import com.jonas.ecommerce.payment.entity.PaymentEntity;
import com.jonas.ecommerce.checkout.event.CheckoutCreatedEvent;

public interface PaymentService {
    Optional<PaymentEntity> create(CheckoutCreatedEvent checkoutCreatedEvent);
}
