package com.nav.spboo.repository;

import com.nav.spboo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findPaymentByComment(String comment);
}
