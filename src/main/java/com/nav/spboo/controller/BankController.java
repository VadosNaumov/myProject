package com.nav.spboo.controller;

import com.nav.spboo.model.Bank;
import com.nav.spboo.service.BankService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService) {
        this.bankService = bankService;
    }

    @GetMapping("/banks")
    public String findAll(Model model) {
        List<Bank> banks = bankService.findAll();
        banks.sort(Bank::compareTo);
        model.addAttribute("banks", banks);
        return "bank-list";
    }

    @GetMapping("/bank-create")
    public String createBankForm(Bank bank) {
        return "bank-create";
    }

    @PostMapping("/bank-create")
    public String createBank(Bank bank) {
        bankService.saveBank(bank);
        return "redirect:/banks";
    }

    @GetMapping("/bank-delete/{id}")
    public String deleteBank(@PathVariable("id") Long id) {
        bankService.deleteById(id);
        return "redirect:/banks";
    }

    @GetMapping("/bank-update/{id}")
    public String updateBankForm(@PathVariable("id") Long id, Model model) {
        Bank bank = bankService.findById(id);
        model.addAttribute("bank", bank);
        return "/bank-update";
    }

    @PostMapping("/bank-update")
    public String updateBank(Bank bank) {
        bankService.saveBank(bank);
        return "redirect:/banks";
    }
}
