package com.kubro.myemployee.dao.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kubro.myemployee.entity.Position;

@Repository
public interface PositionRepository extends PagingAndSortingRepository<Position, Long> {
    Page findAll(Pageable pageable);
}
