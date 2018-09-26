package com.example.dealership.commad.domain.admissions.repositories.entites;

import com.example.dealership.commad.domain.admissions.snapshots.CarSnapshot;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;
import java.util.Date;

import static java.lang.Boolean.FALSE;
import static javax.persistence.TemporalType.DATE;

@Entity
public class Car {

    @Id
    public String id;

    @NotNull
    public String make;

    @NotNull
    public String model;

    @NotNull
    @Temporal(DATE)
    public Date dateOfConstruction;

    @NotNull
    public BigDecimal price;

    @NotNull
    public Currency currency;


    public Boolean isCarValid(){
        return FALSE;
    }

    public String reasonCarInvalid() {
        return "xxx";
    }

    public CarSnapshot snapshot() {
        return new CarSnapshot();
    }
}
