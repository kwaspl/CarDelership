package com.example.dealership.commad.domain.admissions.repositories;

import com.example.dealership.commad.domain.admissions.repositories.entites.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarEntityRepository extends JpaRepository<Car, String> { }

