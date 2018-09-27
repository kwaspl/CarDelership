package com.example.dealership.commad.domain.admissions.events.factories;

import com.example.dealership.commad.domain.admissions.events.events.CarOfferAdmittedEvent;
import com.example.dealership.commad.domain.admissions.snapshots.CarSnapshot;
import com.google.gson.Gson;
import org.springframework.stereotype.Component;

@Component
public class CarEventFactoryImpl implements CarEventFactory {

    @Override
    public String createCarAdmitedEvent(CarSnapshot carSnapshot) {
        Gson gson = new Gson();
        return gson.toJson(new CarOfferAdmittedEvent(carSnapshot));
    }
}
