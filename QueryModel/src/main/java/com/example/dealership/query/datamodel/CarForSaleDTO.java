package com.example.dealership.query.datamodel;

import java.io.Serializable;

public class CarForSaleDTO implements Serializable {

    public final String make;

    public CarForSaleDTO(String make) {
        this.make = make;
    }
}
