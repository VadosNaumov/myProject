package com.nav.spboo.repository;

import com.nav.spboo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findPaymentByAmountGreaterThan(Long amount);

    List<Payment> findPaymentByComment(String comment);

    List<Payment> findPaymentByCommentContains(String word);

    List<Payment> findPaymentByCompany_City_Country_State(String country);
}
