package com.example.dealership.commad.domain.admissions.snapshots;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.Date;

public class CarSnapshot {

    public String id;
    public String make;
    public String model;
    public Date dateOfConstruction;
    public BigDecimal price;
    public String currency;

    public CarSnapshot() {
    }

    public CarSnapshot(String id, String make, String model, Date dateOfConstruction, BigDecimal price, Currency currency) {
        this.id = id;
        this.make = make;
        this.model = model;
        this.dateOfConstruction = dateOfConstruction;
        this.price = price;
        this.currency = currency.getCurrencyCode();
    }
}
