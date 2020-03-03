package com.nav.spboo.service;

import com.nav.spboo.model.Payment;
import com.nav.spboo.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
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

    public List<Payment> findPaymentByComment(String comment){
        return paymentRepository.findPaymentByComment(comment);
    }

    public List<Payment> findPaymentByCommentContains(String word){
        return paymentRepository.findPaymentByCommentContains(word);
    }

    public List<Payment> findPaymentByCompany_City_Country_State(String country){
        return paymentRepository.findPaymentByCompany_City_Country_State(country);
    }
}
