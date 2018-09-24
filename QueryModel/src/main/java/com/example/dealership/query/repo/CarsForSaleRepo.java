package com.example.dealership.query.repo;

import com.example.dealership.query.datamodel.CarQuickDescriptionDTO;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsForSaleRepo extends ReactiveMongoRepository<CarQuickDescriptionDTO, String> { }
