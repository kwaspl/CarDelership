package com.example.dealership.commad.domain.admissions.events.factories;

import com.example.dealership.commad.domain.admissions.events.events.CarAdmittedEvent;
import com.example.dealership.commad.domain.admissions.snapshots.CarSnapshot;
import org.springframework.stereotype.Component;

@Component
public class CarEventFactoryImpl implements CarEventFactory {

    @Override
    public CarAdmittedEvent createCarAdmitedEvent(CarSnapshot carSnapshot) {
        return new CarAdmittedEvent("xx");
    }
}
