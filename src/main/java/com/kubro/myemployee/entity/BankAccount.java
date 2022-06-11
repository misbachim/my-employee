package com.kubro.myemployee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "bank_accounts")
@Setter @Getter
public class BankAccount {

    @Id
    @GeneratedValue()
    private long id;

    @Column(name="`name`", nullable = false)
    private String name;

}
