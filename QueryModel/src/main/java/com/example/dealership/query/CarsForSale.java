package com.example.dealership.query;

import com.example.dealership.query.datamodel.CarForSaleDTO;

import java.util.List;
import java.util.concurrent.Future;

public interface CarsForSale {

    Future<List<CarForSaleDTO>> carsForSale();

    List<CarForSaleDTO> carsForSaleFavoredByTheUser(String userid);

    List<CarForSaleDTO> carsForSaleOfMake(String make);
}

