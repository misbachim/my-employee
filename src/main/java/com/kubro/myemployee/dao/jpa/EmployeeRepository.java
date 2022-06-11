package com.kubro.myemployee.dao.jpa;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kubro.myemployee.entity.Employee;

@Repository
public interface EmployeeRepository extends PagingAndSortingRepository<Employee, UUID> {

    @Query("SELECT e FROM Employee e WHERE LOWER(CONCAT(e.firstName, ' ', e.lastName)) LIKE LOWER(CONCAT('%', :employeeName, '%'))")
    Page findByName(String employeeName, Pageable pageable);
    
    @Query("SELECT e FROM Employee e WHERE e.position.id = :positionId")
    Page findByPositionId(Long positionId, Pageable pageable);
    
    @Query("SELECT e FROM Employee e WHERE LOWER(CONCAT(e.firstName, ' ', e.lastName)) LIKE LOWER(CONCAT('%', :employeeName, '%')) AND e.position.id = :positionId")
    Page findByNameAndPositionId(String employeeName, Long positionId, Pageable pageable);

    Page findAll(Pageable pageable);
}
