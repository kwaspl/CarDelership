package com.example.dealership.query.repo;

import com.example.dealership.query.datamodel.CarForSaleDTO;
import com.hazelcast.core.ICompletableFuture;

import java.util.List;

public interface CarsForSaleRepo {

    ICompletableFuture<List<CarForSaleDTO>> fetchCarsForSale();

}
