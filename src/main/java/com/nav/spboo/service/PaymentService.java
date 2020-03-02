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
}
