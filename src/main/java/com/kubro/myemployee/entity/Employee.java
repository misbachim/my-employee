package com.kubro.myemployee.entity;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "employees")
@Setter @Getter
public class Employee {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
        name = "UUID",
        strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(columnDefinition = "uuid", updatable = false)
    private UUID id;

    @Column(nullable = false)
    private String firstName;

    @Column()
    private String lastName;
    
    @Column()
    private LocalDate dateOfBirth;
    
    @Column()
    private String phoneNumber;
    
    @Column()
    private String emailAddress;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "province_id", referencedColumnName = "id")
    private Province province;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "city_id", referencedColumnName = "id")
    private City city;
    
    @Column()
    private String streetAddress;
    
    @Column()
    private String zipCode;
    
    @Column()
    private String ktpNumber;
    
    @Lob
    @Column()
    private byte[] ktpFile;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "position_id", referencedColumnName = "id")
    private Position position;
    
    @OneToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "bank_account_id", referencedColumnName = "id")
    private BankAccount bankAccount;
    
    @Column()
    private String bankAccountNumber;
    
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column()
    private Date createDate;
    
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column()
    private Date modifyDate;

}
