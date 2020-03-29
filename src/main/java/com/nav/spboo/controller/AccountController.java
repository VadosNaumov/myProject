package com.nav.spboo.controller;

import com.nav.spboo.model.Account;
import com.nav.spboo.model.Bank;
import com.nav.spboo.model.Company;
import com.nav.spboo.service.AccountService;
import com.nav.spboo.service.BankService;
import com.nav.spboo.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class AccountController {

    private final AccountService accountService;
    private final BankService bankService;
    private final CompanyService companyService;

    public AccountController(AccountService accountService, BankService bankService, CompanyService companyService) {
        this.accountService = accountService;
        this.bankService = bankService;
        this.companyService = companyService;
    }

    @GetMapping("/accounts")
    public String findAll(Model model) {
        List<Account> accounts = accountService.findAll();
        accounts.sort(Account::compareTo);
        model.addAttribute("accounts", accounts);
        return "account-list";
    }

    @GetMapping("/account-create")
    public String createAccountForm(Account account, Model model) {
        model.addAttribute("account", account);

        List<Bank> banks = bankService.findAll();
        model.addAttribute("banks", banks);
        List<Company> companies = companyService.findAll();
        model.addAttribute("companies", companies);
        return "account-create";
    }

    @PostMapping("/account-create")
    public String createAccount(Account account) {
        accountService.saveAccount(account);
        return "redirect:/accounts";
    }

    @GetMapping("/account-delete/{id}")
    public String deleteAccount(@PathVariable("id") Long id) {
        accountService.deleteById(id);
        return "redirect:/accounts";
    }

    @GetMapping("/account-update/{id}")
    public String updateAccountForm(@PathVariable("id") Long id, Model model) {
        Account account = accountService.findById(id);
        model.addAttribute("account", account);
        List<Bank> banks = bankService.findAll();
        model.addAttribute("banks", banks);
        List<Company> companies = companyService.findAll();
        model.addAttribute("companies", companies);
        return "account-update";
    }

    @PostMapping("/account-update")
    public String updateAccount(Account account) {
        accountService.saveAccount(account);
        return "redirect:/accounts";
    }
}
