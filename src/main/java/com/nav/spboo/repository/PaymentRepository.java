package com.nav.spboo.repository;

import com.nav.spboo.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

    List<Payment> findPaymentByAmountGreaterThan(Long amount);

    List<Payment> findPaymentByCommentContains(String word);

    List<Payment> findPaymentByCompany_City_Country_State(String country);

    List<Payment> findPaymentByAmountGreaterThanAndCommentContainsAndCompany_City_Country_State
            (Long amount, String word, String country);

    List<Payment> findPaymentByAmountGreaterThanAndCommentContains
            (Long amount, String word);

    List<Payment> findPaymentByAmountGreaterThanAndCompany_City_Country_State(Long amount, String country);

    List<Payment> findPaymentByCommentContainsAndCompany_City_Country_State(String word, String country);
}
