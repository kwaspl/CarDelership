package com.example.dealership.query.datamodel;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document
public class CarDetailsDTO {

    @Id
    public final String id;
    public final String make;
    public final String fueltype;
    public final LocalDateTime yearOfProduction;
    public final Long milage;

    public CarDetailsDTO(String id, String make, String fueltype, LocalDateTime yearOfProduction, Long milage) {
        this.id = id;
        this.make = make;
        this.fueltype = fueltype;
        this.yearOfProduction = yearOfProduction;
        this.milage = milage;
    }
}
