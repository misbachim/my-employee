package com.kubro.myemployee.dao.jpa;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.kubro.myemployee.entity.BankAccount;

@Repository
public interface BankAccountRepository extends PagingAndSortingRepository<BankAccount, Long> {
    Page findAll(Pageable pageable);
}
