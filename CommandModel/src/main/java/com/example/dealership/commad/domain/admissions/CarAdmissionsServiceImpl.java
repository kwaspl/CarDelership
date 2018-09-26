package com.example.dealership.commad.domain.admissions;

import com.example.dealership.commad.datamodel.NewCarDTO;
import com.example.dealership.commad.domain.admissions.events.factories.CarEventFactory;
import com.example.dealership.commad.domain.admissions.repositories.factory.JPACarFactory;
import com.example.dealership.commad.domain.admissions.repositories.CarEntityRepository;
import com.example.dealership.commad.domain.admissions.repositories.entites.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
public class CarAdmissionsServiceImpl implements CarAdmissionsService {

    @Autowired
    CarEntityRepository carRepository;

    @Autowired
    JPACarFactory jpaCarFactory;

    @Autowired
    CarEventFactory carEventFactory;

    @Autowired
    ApplicationEventPublisher applicationEventPublisher;

    @Override
    public String admitNewCar(NewCarDTO newCar) {
        Car car = jpaCarFactory.createCarOfThrowExceptionIfSubmissonInvalid(newCar);
        carRepository.save(car);
        applicationEventPublisher.publishEvent(carEventFactory.createCarAdmitedEvent(car.snapshot()));
        return car.id;
    }
}
