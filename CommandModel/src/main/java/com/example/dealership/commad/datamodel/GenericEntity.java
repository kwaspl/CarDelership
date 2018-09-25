package com.example.dealership.commad.datamodel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long id;
    public String value;

    public GenericEntity() { }
    public GenericEntity(String value) {
        this.value = value;
    }
}

