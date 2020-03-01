package com.nav.spboo.service;

import com.nav.spboo.model.Bank;
import com.nav.spboo.repository.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankService {

    private final BankRepository bankRepository;

    @Autowired
    public BankService(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    public Bank findById(Long id){
        return bankRepository.getOne(id);
    }

    public List<Bank> findAll(){
        return bankRepository.findAll();
    }

    public Bank saveBank(Bank bank){
        return bankRepository.save(bank);
    }

    public void deleteById(Long id){
        bankRepository.deleteById(id);
    }
}
