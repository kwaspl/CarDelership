package com.example.dealership.query;

import com.example.dealership.query.datamodel.CarDetailsDTO;
import com.example.dealership.query.datamodel.CarQuickDescriptionDTO;
import com.example.dealership.query.repo.CarsForSaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

import static java.util.Collections.emptyList;

@Component
public class CarsForSaleImpl implements CarsForSale {

    @Autowired
    CarsForSaleRepo carsForSaleRepo;

    @Override
    public Flux<CarQuickDescriptionDTO> carsForSale() {
        return carsForSaleRepo.findAll();
    }

    @Override
    public Mono<CarDetailsDTO> carDetails(String id) {
        return null;
    }

}
