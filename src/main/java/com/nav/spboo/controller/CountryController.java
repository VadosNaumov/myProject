package com.nav.spboo.controller;

import com.nav.spboo.service.CountryService;
import com.nav.spboo.model.Country;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class CountryController {

    private final CountryService countryService;

    public CountryController(CountryService countryService) {
        this.countryService = countryService;
    }

    @GetMapping("/countries")
    public String findAll(Model model) {
        List<Country> countries = countryService.findAll();
        model.addAttribute("countries", countries);
        return "/country-list";
    }

    @GetMapping("/country-create")
    public String createCountryForm(Country country) {
        return "/country-create";
    }

    @PostMapping("/country-create")
    public String createCountry(Country country) {
        countryService.saveCountry(country);
        return "redirect:/countries";
    }

    @GetMapping("/country-delete/{id}")
    public String deleteCountry(@PathVariable("id") Long id) {
        countryService.deleteById(id);
        return "redirect:/countries";
    }

    @GetMapping("/country-update/{id}")
    public String updateCountryForm(@PathVariable("id") Long id, Model model) {
        Country country = countryService.findById(id);
        model.addAttribute("country", country);
        return "/country-update";
    }

    @PostMapping("/country-update")
    public String updateCountry(Country country) {
        countryService.saveCountry(country);
        return "redirect:/countries";
    }
}
