package com.example.dealership.commad.domain.admissions.events.factories;

import com.example.dealership.commad.domain.admissions.snapshots.CarSnapshot;

public interface CarEventFactory {
    String createCarAdmitedEvent(CarSnapshot carSnapshot);
}
