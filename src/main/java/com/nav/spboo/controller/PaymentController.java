package com.nav.spboo.controller;

import com.nav.spboo.model.*;
import com.nav.spboo.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class PaymentController {

    private final CompanyService companyService;
    private final PaymentService paymentService;

    public PaymentController(CompanyService companyService,
                             PaymentService paymentService) {
        this.companyService = companyService;
        this.paymentService = paymentService;
    }

    @GetMapping("/payments")
    public String findAll(Model model) {
        List<Payment> payments = paymentService.findAll();
        payments.sort(Payment::compareTo);
        model.addAttribute("payments", payments);
        return "payment-list";
    }

    @GetMapping("/payment-create")
    public String createPaymentForm(Payment payment, Model model) {
        model.addAttribute("payment", payment);
        List<Company> companies = companyService.findAll();
        model.addAttribute("companies", companies);
        return "payment-create";
    }

    @PostMapping("/payment-create")
    public String createPayment(Payment payment) {
        paymentService.savePayment(payment);
        return "redirect:/payments";
    }

    @GetMapping("/payment-delete/{id}")
    public String deletePayment(@PathVariable("id") Long id) {
        paymentService.deleteById(id);
        return "redirect:/payments";
    }

    @GetMapping("/payment-update/{id}")
    public String updatePaymentForm(@PathVariable("id") Long id, Model model) {
        Payment payment = paymentService.findById(id);
        model.addAttribute("payment", payment);
        List<Company> companies = companyService.findAll();
        model.addAttribute("companies", companies);
        return "/payment-update";
    }

    @PostMapping("/payment-update")
    public String updatePayment(Payment payment) {
        paymentService.savePayment(payment);
        return "redirect:/payments";
    }

    @GetMapping("/payment-search")
    public String findPaymentForm(Payment payment) {
        return "/payment-search";
    }

    @PostMapping("/payment-search")
    public String findPayment(@RequestParam(name = "comment") String comment,
                                Model model){
        Iterable<Payment> payments;
        if (comment != null && !comment.isEmpty()){
            payments = paymentService.findPaymentByComment(comment);
        } else {
            payments = paymentService.findAll();
        }
        model.addAttribute("payments", payments);
        return "/payment-search-result";
    }

    @GetMapping("/payment-search-result")
    public String findPaymentByComment(Payment payment, Model model) {
        List<Payment> payments = paymentService.findAll();
        model.addAttribute("payments", payments);
        return "/payment-search-result";
    }

}
