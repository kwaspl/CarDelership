package com.example.dealership.query;

import com.example.dealership.query.datamodel.CarDetailsDTO;
import com.example.dealership.query.datamodel.CarQuickDescriptionDTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CarsForSale {

    Flux<CarQuickDescriptionDTO> carsForSale();

    Mono<CarDetailsDTO> carDetails(String id);

}

