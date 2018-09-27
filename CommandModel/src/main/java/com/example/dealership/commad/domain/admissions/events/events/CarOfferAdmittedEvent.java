package com.example.dealership.commad.domain.admissions.events.events;

import com.example.dealership.commad.domain.admissions.snapshots.CarSnapshot;

public class CarOfferAdmittedEvent {

    public CarSnapshot payload;

    public CarOfferAdmittedEvent() {
    }

    public CarOfferAdmittedEvent(CarSnapshot payload) {
        this.payload = payload;
    }


}
