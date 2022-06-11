package com.kubro.myemployee.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.kubro.myemployee.dao.jpa.BankAccountRepository;
import com.kubro.myemployee.entity.BankAccount;

@Service
public class BankAccountService {

    private static final Logger log = LoggerFactory.getLogger(BankAccountService.class);

    @Autowired
    private BankAccountRepository employeeRepository;

    public BankAccountService() {
    }

    public BankAccount createBankAccount(BankAccount bankAccount) {
        return employeeRepository.save(bankAccount);
    }

    public BankAccount getBankAccount(long id) {
        return employeeRepository.findById(id).get();
    }

    public void updateBankAccount(BankAccount bankAccount) {
        employeeRepository.save(bankAccount);
    }

    public void deleteBankAccount(Long id) {
        employeeRepository.deleteById(id);
    }

    public Page<BankAccount> getAllBankAccounts(Integer page, Integer size) {
        Page pageOfBankAccounts = employeeRepository.findAll(PageRequest.of(page, size));
        return pageOfBankAccounts;
    }
    
}
