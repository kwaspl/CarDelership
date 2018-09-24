package com.example.dealership.query.repo;

import com.example.dealership.query.datamodel.CarForSaleDTO;
import reactor.core.publisher.Flux;

import java.util.List;

public interface CarsForSaleRepo {

    Flux<List<CarForSaleDTO>> fetchCarsForSale();

}
