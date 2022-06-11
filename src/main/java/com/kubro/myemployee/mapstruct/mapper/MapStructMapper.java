package com.kubro.myemployee.mapstruct.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import com.kubro.myemployee.entity.BankAccount;
import com.kubro.myemployee.entity.City;
import com.kubro.myemployee.entity.Employee;
import com.kubro.myemployee.entity.Position;
import com.kubro.myemployee.entity.Province;
import com.kubro.myemployee.mapstruct.dto.BankAccountDto;
import com.kubro.myemployee.mapstruct.dto.CityDto;
import com.kubro.myemployee.mapstruct.dto.EmployeeDto;
import com.kubro.myemployee.mapstruct.dto.PositionDto;
import com.kubro.myemployee.mapstruct.dto.ProvinceDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.WARN)
public interface MapStructMapper {
    BankAccountDto bankAccountToBankAccountDto(BankAccount bankAccount);

    CityDto cityToCityDto(City city);

    EmployeeDto employeeToEmployeeDto(Employee employee);

    PositionDto positionToPositionDto(Position position);

    ProvinceDto provinceToProvinceDto(Province province);

}