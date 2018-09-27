package com.example.dealership.commad.domain.admissions;

import com.example.dealership.commad.datamodel.CarId;
import com.example.dealership.commad.datamodel.NewCarOfferDTO;

public interface CarOfferAdmissionsService {
    CarId admitNewCarOffer(NewCarOfferDTO newCar);
}
