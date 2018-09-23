package com.example.dealership.query.repo;

import com.example.dealership.query.datamodel.CarForSaleDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

@Component
public class CarsForSaleRepoImpl implements CarsForSaleRepo {

    @Autowired
    private CarsCache cache;

    @Override
    public Future<List<CarForSaleDTO>> fetchCarsForSale() {
        return cache.get();
    }
}
