package com.example.dealership.commad.datamodel;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Currency;

public class NewCarDTO {

    public String make;
    public String model;
    public LocalDateTime dateOfConstruction;
    public BigDecimal price;
    public Currency currency;

    public NewCarDTO(String make, String model, LocalDateTime dateOfConstruction, BigDecimal price, Currency currency) {
        this.make = make;
        this.model = model;
        this.dateOfConstruction = dateOfConstruction;
        this.price = price;
        this.currency = currency;
    }

    public NewCarDTO() {
    }
}
