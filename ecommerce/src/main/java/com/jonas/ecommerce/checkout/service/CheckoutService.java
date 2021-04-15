package com.jonas.ecommerce.checkout.service;

import java.util.Optional;

import com.jonas.ecommerce.checkout.entity.CheckoutEntity;
import com.jonas.ecommerce.checkout.resource.checkout.CheckoutRequest;

public interface CheckoutService {
    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

    Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status);
}
