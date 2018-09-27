package com.example.dealership.commad.domain.admissions;

import com.example.dealership.commad.datamodel.CarId;
import com.example.dealership.commad.datamodel.NewCarOfferDTO;
import com.example.dealership.commad.domain.admissions.events.factories.CarEventFactory;
import com.example.dealership.commad.domain.admissions.repositories.CarOfferEntityRepository;
import com.example.dealership.commad.domain.admissions.repositories.entites.CarOffer;
import com.example.dealership.commad.domain.admissions.repositories.factory.JPACarOfferFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class CarOfferAdmissionsServiceImpl implements CarOfferAdmissionsService {

    @Autowired
    CarOfferEntityRepository carRepository;

    @Autowired
    JPACarOfferFactory jpaCarOfferFactory;

    @Autowired
    CarEventFactory carEventFactory;

    @Autowired
    private JmsTemplate jmsTemplate;

    @Value("${domain.events.offer.admitted}")
    private String carOfferAdmittedQueue;

    @Override
    public CarId admitNewCarOffer(NewCarOfferDTO newCar) {
        CarOffer car = jpaCarOfferFactory.createCarOfThrowExceptionIfSubmissonInvalid(newCar);
        carRepository.save(car);
        jmsTemplate.convertAndSend(carOfferAdmittedQueue, carEventFactory.createCarAdmitedEvent(car.snapshot()));
        return new CarId(car.id);
    }
}
