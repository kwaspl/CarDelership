package com.example.dealership.query;

import com.example.dealership.query.datamodel.CarQuickDescriptionDTO;
import com.example.dealership.query.repo.CarsForSaleRepo;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import java.util.concurrent.ExecutionException;

@RunWith(SpringRunner.class)
@SpringBootTest({"env.carsDbName=cars_db", "env.dbConnectionString=mongodb://localhost"})
public class CarsForSaleRepoImplITest {

    public static final CarQuickDescriptionDTO audi = new CarQuickDescriptionDTO("1", "audi");
    public static final CarQuickDescriptionDTO mercedes = new CarQuickDescriptionDTO("2", "mercedes");
    public static final CarQuickDescriptionDTO fiat = new CarQuickDescriptionDTO("2", "fiat");
    public static final CarQuickDescriptionDTO chevrolet = new CarQuickDescriptionDTO("3", "chevrolet");

    @Autowired
    CarsForSaleRepo repo;

    @Test
    public void fetchCarsForSale_listInFutureNotNull() throws ExecutionException, InterruptedException {
        final Flux<CarQuickDescriptionDTO> carForSaleDTOFlux = repo.findAll();

        StepVerifier
                .create(carForSaleDTOFlux)
                .expectSubscription()
                .assertNext( (car) -> Assertions.assertThat(car.id).isEqualTo("1"))
                .verifyComplete();
    }

    @Before
    public void putDataInCache(){
        repo.save(audi).subscribe();
    }

    @SpringBootApplication
    @EnableCaching
    static class SpringConfiguration {}

}