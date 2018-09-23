package com.example.dealership.query.repo;

import com.example.dealership.query.datamodel.CarForSaleDTO;

import java.util.List;
import java.util.concurrent.Future;

public interface CarsForSaleRepo {

    Future<List<CarForSaleDTO>> fetchCarsForSale();

}
