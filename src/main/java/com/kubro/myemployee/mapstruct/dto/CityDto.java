package com.kubro.myemployee.mapstruct.dto;

import lombok.Getter;
import lombok.Setter;

@Setter @Getter
public class CityDto {

    private long id;

    private String name;

    private ProvinceDto province;

}
