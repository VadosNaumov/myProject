package com.nav.spboo.controller;

import com.nav.spboo.model.Company;
import com.nav.spboo.service.CompanyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/companies")
    public String findAll(Model model) {
        List<Company> companies = companyService.findAll();
        model.addAttribute("companies", companies);
        return "company-list";
    }

    @GetMapping("/company-create")
    public String createCompanyForm(Company company) {
        return "company-create";
    }

    @PostMapping("/company-create")
    public String createCompany(Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/company-delete/{id}")
    public String deleteCompany(@PathVariable("id") Long id) {
        companyService.deleteById(id);
        return "redirect:/companies";
    }

    @GetMapping("/company-update/{id}")
    public String updateCompanyForm(@PathVariable("id") Long id, Model model) {
        Company company = companyService.findById(id);
        model.addAttribute("company", company);
        return "/company-update";
    }

    @PostMapping("/company-update")
    public String updateCompany(Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";
    }
}
