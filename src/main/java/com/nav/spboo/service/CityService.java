package com.nav.spboo.service;

import com.nav.spboo.model.City;
import com.nav.spboo.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    public final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public City findById(Long id){
        return cityRepository.getOne(id);
    }

    public List<City> findAll(){
        return cityRepository.findAll();
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }

    public void deleteById(Long id){
        cityRepository.deleteById(id);
    }
}
