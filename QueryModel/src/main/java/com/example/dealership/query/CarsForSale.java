package com.example.dealership.query;

import com.example.dealership.query.datamodel.CarForSaleDTO;
import com.hazelcast.core.ICompletableFuture;

import java.util.List;

public interface CarsForSale {

    ICompletableFuture<List<CarForSaleDTO>> carsForSale();

    List<CarForSaleDTO> carsForSaleFavoredByTheUser(String userid);

    List<CarForSaleDTO> carsForSaleOfMake(String make);
}

