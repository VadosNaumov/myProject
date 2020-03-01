package com.nav.spboo.service;

import com.nav.spboo.model.Account;
import com.nav.spboo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account findById(Long id){
        return accountRepository.getOne(id);
    }

    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    public Account saveAccount(Account account){
        return accountRepository.save(account);
    }

    public void deleteById(Long id){
        accountRepository.deleteById(id);
    }
}
