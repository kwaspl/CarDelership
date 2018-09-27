package com.example.dealership.commad.datamodel;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.math.BigDecimal;
import java.util.Date;

public class NewCarOfferDTO {

    public String make;
    public String model;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    public Date dateOfConstruction;
    public BigDecimal price;
    public String currency;

    public NewCarOfferDTO() {
    }
}
