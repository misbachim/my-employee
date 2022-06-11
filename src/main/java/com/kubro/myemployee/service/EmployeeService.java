package com.kubro.myemployee.service;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.kubro.myemployee.dao.jpa.EmployeeRepository;
import com.kubro.myemployee.entity.Employee;

@Service
public class EmployeeService {

    private static final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    @Autowired
    private EmployeeRepository employeeRepository;

    public EmployeeService() {
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee getEmployee(UUID id) {
        return employeeRepository.findById(id).get();
    }

    public void updateEmployee(Employee employee) {
        if (employee.getKtpFile() == null) {
            Employee currentEmployee = getEmployee(employee.getId());
            employee.setKtpFile(currentEmployee.getKtpFile());
        }
        employeeRepository.save(employee);
    }

    public void deleteEmployee(UUID id) {
        employeeRepository.deleteById(id);
    }

    public Page<Employee> getAllEmployees(Integer page, Integer size) {
        Page pageOfEmployees = employeeRepository.findAll(PageRequest.of(page, size, Sort.by("modifyDate").descending()));
        return pageOfEmployees;
    }

    public Page<Employee> getByName(String name, Integer page, Integer size) {
        Page pageOfEmployees = employeeRepository.findByName(name, PageRequest.of(page, size, Sort.by("modifyDate").descending()));
        return pageOfEmployees;
    }

    public Page<Employee> getByPositionId(Long positionId, Integer page, Integer size) {
        Page pageOfEmployees = employeeRepository.findByPositionId(positionId, PageRequest.of(page, size, Sort.by("modifyDate").descending()));
        return pageOfEmployees;
    }

    public Page<Employee> getByNameAndPositionId(String name, Long positionId, Integer page, Integer size) {
        Page pageOfEmployees = employeeRepository.findByNameAndPositionId(name, positionId, PageRequest.of(page, size, Sort.by("modifyDate").descending()));
        return pageOfEmployees;
    }

}
