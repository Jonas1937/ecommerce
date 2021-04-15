package com.jonas.ecommerce.checkout.listener;

import com.jonas.ecommerce.checkout.entity.CheckoutEntity;
import com.jonas.ecommerce.checkout.streaming.PaymentPaidSink;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {
    
    private final CheckoutService checkoutService;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent paymentCreatedEvent) {
        checkoutService.updateStatus(paymentCreatedEvent.getCheckoutCode().toString(), CheckoutEntity.Status.APPROVED);
    }
}
