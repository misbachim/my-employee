package com.kubro.myemployee.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "provinces")
@Setter @Getter
public class Province {

    @Id
    @GeneratedValue()
    private long id;

    @Column(name="`name`", nullable = false)
    private String name;

    @OneToMany(targetEntity=City.class, mappedBy="province",cascade=CascadeType.ALL, fetch = FetchType.LAZY)    
    private List<City> cities;

}
