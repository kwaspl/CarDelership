package com.example.dealership.query;

import com.example.dealership.query.datamodel.CarForSaleDTO;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CarsForSale {

    Flux<List<CarForSaleDTO>> carsForSale();

    List<CarForSaleDTO> carsForSaleFavoredByTheUser(String userid);

    List<CarForSaleDTO> carsForSaleOfMake(String make);
}

