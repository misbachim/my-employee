package com.kubro.myemployee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kubro.myemployee.dao.jpa.CityRepository;
import com.kubro.myemployee.entity.City;

@Service
public class CityService {

    private static final Logger log = LoggerFactory.getLogger(CityService.class);

    @Autowired
    private CityRepository cityRepository;

    public CityService() {
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City getCity(long id) {
        return cityRepository.findById(id).get();
    }

    public void updateCity(City city) {
        cityRepository.save(city);
    }

    public void deleteCity(Long id) {
        cityRepository.deleteById(id);
    }

    public Page<City> getAllCitys(Integer page, Integer size) {
        Page pageOfCitys = cityRepository.findAll(PageRequest.of(page, size));
        return pageOfCitys;
    }    

    public Page<City> getByProvinceId(Long provinceId, Integer page, Integer size) {
        Page pageOfCitys = cityRepository.findByProvinceId(provinceId, PageRequest.of(page, size));
        return pageOfCitys;
    }
    
}
