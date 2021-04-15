package com.jonas.ecommerce.payment.listener;

import com.jonas.ecommerce.checkout.event.CheckoutCreatedEvent;
import com.jonas.ecommerce.payment.entity.PaymentEntity;
import com.jonas.ecommerce.payment.event.PaymentCreatedEvent;
import com.jonas.ecommerce.payment.service.PaymentService;
import com.jonas.ecommerce.payment.streaming.CheckoutProcessor;

import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentCreatedListener {
    
    private final CheckoutProcessor checkoutProcessor;

    private final PaymentService paymentService;

    @StreamListener(CheckoutProcessor.INPUT)
    public void handler(CheckoutCreatedEvent checkoutCreatedEvent){
        final PaymentEntity paymentEntity = paymentService.create(checkoutCreatedEvent).orElseThrow();
        final PaymentCreatedEvent paymentCreatedEvent = PaymentCreatedEvent.newBuilder()
                .setCheckoutCode(paymentEntity.getCheckoutCode())
                .setPaymentCode(paymentEntity.getCode())
                .build();
        checkoutProcessor.output().send(MessageBuilder.withPayload(paymentCreatedEvent).build());
    }
    }
