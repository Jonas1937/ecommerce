package com.jonas.ecommerce.payment.repository;

import com.jonas.ecommerce.payment.entity.PaymentEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<PaymentEntity, Long>{
    
}
