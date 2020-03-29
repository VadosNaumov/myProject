package com.nav.spboo.controller;

import com.nav.spboo.model.Account;
import com.nav.spboo.model.City;
import com.nav.spboo.model.Company;
import com.nav.spboo.model.User;
import com.nav.spboo.service.AccountService;
import com.nav.spboo.service.CityService;
import com.nav.spboo.service.CompanyService;
import com.nav.spboo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CompanyController {

    private final CompanyService companyService;
    private final AccountService accountService;
    private final CityService cityService;
    private final UserService userService;

    public CompanyController(CompanyService companyService,
                             AccountService accountService,
                             CityService cityService,
                             UserService userService) {
        this.companyService = companyService;
        this.accountService = accountService;
        this.cityService = cityService;
        this.userService = userService;
    }

    @GetMapping("/companies")
    public String findAll(Model model) {
        List<Company> companies = companyService.findAll();
        companies.sort(Company::compareTo);
        model.addAttribute("companies", companies);
        return "company-list";
    }

    @GetMapping("/company-create")
    public String createCompanyForm(Company company, Model model) {
        model.addAttribute("company", company);
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
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
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        List<Account> accounts = accountService.findAll();
        model.addAttribute("accounts", accounts);
        return "company-update";
    }

    @PostMapping("/company-update")
    public String updateCompany(Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";
    }
}
