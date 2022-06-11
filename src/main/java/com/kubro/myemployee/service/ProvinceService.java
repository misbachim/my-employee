package com.kubro.myemployee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kubro.myemployee.dao.jpa.ProvinceRepository;
import com.kubro.myemployee.entity.Province;

@Service
public class ProvinceService {

    private static final Logger log = LoggerFactory.getLogger(ProvinceService.class);

    @Autowired
    private ProvinceRepository positionRepository;

    public ProvinceService() {
    }

    public Province createProvince(Province city) {
        return positionRepository.save(city);
    }

    public Province getProvince(long id) {
        return positionRepository.findById(id).get();
    }

    public void updateProvince(Province city) {
        positionRepository.save(city);
    }

    public void deleteProvince(Long id) {
        positionRepository.deleteById(id);
    }

    public Page<Province> getAllProvinces(Integer page, Integer size) {
        Page pageOfProvinces = positionRepository.findAll(PageRequest.of(page, size));
        return pageOfProvinces;
    }
    
}
