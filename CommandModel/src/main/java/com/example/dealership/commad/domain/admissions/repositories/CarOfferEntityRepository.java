package com.example.dealership.commad.domain.admissions.repositories;

import com.example.dealership.commad.domain.admissions.repositories.entites.CarOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarOfferEntityRepository extends JpaRepository<CarOffer, String> { }

