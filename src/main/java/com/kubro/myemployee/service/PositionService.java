package com.kubro.myemployee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kubro.myemployee.dao.jpa.PositionRepository;
import com.kubro.myemployee.entity.Position;

@Service
public class PositionService {

    private static final Logger log = LoggerFactory.getLogger(PositionService.class);

    @Autowired
    private PositionRepository positionRepository;

    public PositionService() {
    }

    public Position createPosition(Position city) {
        return positionRepository.save(city);
    }

    public Position getPosition(long id) {
        return positionRepository.findById(id).get();
    }

    public void updatePosition(Position city) {
        positionRepository.save(city);
    }

    public void deletePosition(Long id) {
        positionRepository.deleteById(id);
    }

    public Page<Position> getAllPositions(Integer page, Integer size) {
        Page pageOfPositions = positionRepository.findAll(PageRequest.of(page, size));
        return pageOfPositions;
    }
    
}
