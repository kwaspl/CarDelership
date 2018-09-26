package com.example.dealership.commad.domain.admissions.repositories.factory;

import com.example.dealership.commad.datamodel.NewCarDTO;
import com.example.dealership.commad.domain.admissions.repositories.entites.Car;

public interface JPACarFactory {
    Car createCarOfThrowExceptionIfSubmissonInvalid(NewCarDTO newCar);
}
