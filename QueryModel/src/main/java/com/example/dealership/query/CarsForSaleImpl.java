package com.example.dealership.query;

import com.example.dealership.query.datamodel.CarForSaleDTO;
import com.example.dealership.query.repo.CarsForSaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

import static java.util.Collections.emptyList;

@Component
public class CarsForSaleImpl implements CarsForSale {

    @Autowired
    CarsForSaleRepo carsForSaleRepo;

    @Override
    public Future<List<CarForSaleDTO>> carsForSale() {
        return carsForSaleRepo.fetchCarsForSale();
    }

    @Override
    public List<CarForSaleDTO> carsForSaleFavoredByTheUser(String userid) {
        return emptyList();
    }

    @Override
    public List<CarForSaleDTO> carsForSaleOfMake(String make) {
        return emptyList();
    }
}
