package com.nav.spboo.controller;

import com.nav.spboo.model.City;
import com.nav.spboo.service.CityService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Comparator;
import java.util.List;

@Controller
public class CityController {

    private final CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/cities")
    public String findAll(Model model){
        List<City> cities = cityService.findAll();
        cities.sort(City::compareTo);
        model.addAttribute("cities", cities);
        return "/city-list";
    }

    @GetMapping("/city-create")
    public String createCityForm(City city, Model model){
        model.addAttribute("city", city);
        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "/city-create";
    }

    @PostMapping("/city-create")
    public String createCity(City city){
        cityService.saveCity(city);
        return "redirect:/cities";
    }

    @GetMapping("/city-delete/{id}")
    public String deleteCity(@PathVariable("id") Long id){
        cityService.deleteById(id);
        return "redirect:/cities";
    }

    @GetMapping("/city-update/{id}")
    public String updateCityForm(@PathVariable("id") Long id, Model model){
        City city = cityService.findById(id);
        model.addAttribute("city", city);

        List<City> cities = cityService.findAll();
        model.addAttribute("cities", cities);
        return "/city-update";
    }

    @PostMapping("/city-update")
    public String updateCity(City city){
        cityService.saveCity(city);
        return "redirect:/cities";
    }
}
