package com.jonas.ecommerce.checkout.repository;

import java.util.Optional;

import com.jonas.ecommerce.checkout.entity.CheckoutEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CheckoutRepository extends JpaRepository<CheckoutEntity, Long> {
    
    Optional<CheckoutEntity> findByCode(String code);
}
