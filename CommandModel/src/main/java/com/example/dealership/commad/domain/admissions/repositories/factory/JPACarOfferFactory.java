package com.example.dealership.commad.domain.admissions.repositories.factory;

import com.example.dealership.commad.datamodel.NewCarOfferDTO;
import com.example.dealership.commad.domain.admissions.repositories.entites.CarOffer;

public interface JPACarOfferFactory {
    CarOffer createCarOfThrowExceptionIfSubmissonInvalid(NewCarOfferDTO newCar);
}
