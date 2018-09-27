package com.example.dealership.commad.domain.admissions.repositories.factory;

import com.example.dealership.commad.datamodel.NewCarOfferDTO;
import com.example.dealership.commad.domain.admissions.repositories.entites.CarOffer;
import org.springframework.stereotype.Component;

import java.util.Currency;

import static java.util.UUID.randomUUID;

@Component
public class JPACarOfferFactoryImpl implements JPACarOfferFactory {

    @Override
    public CarOffer createCarOfThrowExceptionIfSubmissonInvalid(NewCarOfferDTO newCar) {
        String id = randomUUID().toString();
        CarOffer car = new CarOffer(id, newCar.make, newCar.model, newCar.dateOfConstruction, newCar.price, Currency.getInstance("USD"));
        return car;
    }

}
