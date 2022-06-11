package com.kubro.myemployee.dao.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kubro.myemployee.entity.City;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Long> {
    Page findAll(Pageable pageable);
    Page findByProvinceId(Long provinceId, Pageable pageable);
}
