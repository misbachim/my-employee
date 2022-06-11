package com.kubro.myemployee.mapstruct.dto;

import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class EmployeeDto {

    private UUID id;

    private String firstName;

    private String lastName;
    
    private LocalDate dateOfBirth;
    
    private String phoneNumber;
    
    private String emailAddress;
    
    private ProvinceDto province;
    
    private CityDto city;
    
    private String streetAddress;
    
    private String zipCode;
    
    private String ktpNumber;
    
    private PositionDto position;
    
    private BankAccountDto bankAccount;
    
    private String bankAccountNumber;

    private Date createDate;

    private Date modifyDate;
}
