package com.nav.spboo.service;

import com.nav.spboo.model.Payment;
import com.nav.spboo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Autowired
    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public Payment findById(Long id){
        return paymentRepository.getOne(id);
    }

    public List<Payment> findAll(){
        return paymentRepository.findAll();
    }

    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public void deleteById(Long id){
        paymentRepository.deleteById(id);
    }

    public List<Payment> findPaymentByAmountGreaterThan(Long amount){
        return paymentRepository.findPaymentByAmountGreaterThan(amount);
    }

    public List<Payment> findPaymentByCommentContains(String word){
        return paymentRepository.findPaymentByCommentContains(word);
    }

    public List<Payment> findPaymentByCompany_City_Country_State(String country){
        return paymentRepository.findPaymentByCompany_City_Country_State(country);
    }

    public List<Payment> findPaymentByAmountGreaterThanAndCommentContainsAndCompany_City_Country_State
            (Long amount, String word, String country){
        return paymentRepository.findPaymentByAmountGreaterThanAndCommentContainsAndCompany_City_Country_State(
                amount, word, country);
    }

    public List<Payment> findPaymentByAmountGreaterThanAndCommentContains
            (Long amount, String word){
        return paymentRepository.findPaymentByAmountGreaterThanAndCommentContains(amount, word);
    }

    public List<Payment> findPaymentByAmountGreaterThanAndCompany_City_Country_State(Long amount, String country){
        return paymentRepository.findPaymentByAmountGreaterThanAndCompany_City_Country_State(amount, country);
    }

    public List<Payment> findPaymentByCommentContainsAndCompany_City_Country_State(String word, String country){
        return paymentRepository.findPaymentByCommentContainsAndCompany_City_Country_State(word, country);
    }
}
