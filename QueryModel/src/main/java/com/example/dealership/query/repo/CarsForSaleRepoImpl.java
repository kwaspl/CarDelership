package com.example.dealership.query.repo;

import com.example.dealership.query.datamodel.CarForSaleDTO;
import com.hazelcast.core.ICompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CarsForSaleRepoImpl implements CarsForSaleRepo {

    @Autowired
    private CarsCache cache;

    @Override
    public ICompletableFuture<List<CarForSaleDTO>> fetchCarsForSale() {
        return cache.get();
    }
}
