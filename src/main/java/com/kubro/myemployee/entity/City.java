package com.kubro.myemployee.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "cities")
@Setter @Getter
public class City {

    @Id
    @GeneratedValue()
    private long id;

    @Column(name="`name`", nullable = false)
    private String name;

    @ManyToOne()
    @JoinColumn(name="province_id", insertable = false, updatable = false)    
    private Province province;

}
