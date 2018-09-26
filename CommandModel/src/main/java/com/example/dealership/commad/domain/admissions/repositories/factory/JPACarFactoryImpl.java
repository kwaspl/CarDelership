package com.example.dealership.commad.domain.admissions.repositories.factory;

import com.example.dealership.commad.datamodel.NewCarDTO;
import com.example.dealership.commad.domain.admissions.repositories.entites.Car;
import org.springframework.stereotype.Component;

@Component
public class JPACarFactoryImpl implements JPACarFactory {

    @Override
    public Car createCarOfThrowExceptionIfSubmissonInvalid(NewCarDTO newCar) {
        return null;
    }
}
