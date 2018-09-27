package com.example.dealership.commad.domain.admissions.repositories.entites;

import com.example.dealership.commad.domain.admissions.snapshots.CarSnapshot;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

import static java.lang.Boolean.FALSE;
import static javax.persistence.TemporalType.DATE;

@Entity
public class CarOffer {

    @Id
    public final String id;

    @NotNull
    private String make;

    @NotNull
    private String model;

    @NotNull
    @Temporal(DATE)
    private Date dateOfConstruction;

    @NotNull
    private BigDecimal price;

    @NotNull
    private Currency currency;

    public CarOffer() {
        this.id = null;
    }

    public CarOffer(String id) {
        this.id = id;
    }

    public CarOffer(String id, @NotNull String make, @NotNull String model, @NotNull Date dateOfConstruction, @NotNull BigDecimal price, @NotNull Currency currency) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.dateOfConstruction = dateOfConstruction;
        this.price = price;
        this.currency = currency;
    }

    public Boolean isCarValid(){
        return FALSE;
    }

    public String reasonCarInvalid() {
        return "xxx";
    }

    public CarSnapshot snapshot() {
        return new CarSnapshot(id, make, model, dateOfConstruction, price, currency );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CarOffer car = (CarOffer) o;

        return id.equals(car.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
