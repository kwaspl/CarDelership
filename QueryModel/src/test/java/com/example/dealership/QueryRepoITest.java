package com.example.dealership;

import com.example.dealership.query.datamodel.CarQuickDescriptionDTO;
import com.example.dealership.query.repo.CarsForSaleRepo;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest({"env.carsDbName=cars_db", "env.dbConnectionString=mongodb://localhost"})
@FixMethodOrder(value = MethodSorters.NAME_ASCENDING)
public class QueryRepoITest {

    public static final CarQuickDescriptionDTO audi = new CarQuickDescriptionDTO("1", "audi");

    @Autowired
    CarsForSaleRepo carsForSaleRepo;

    @Test
    public void canaryTest() {
        assertThat(carsForSaleRepo).isNotNull();
    }

    @Test
    public void fetchCarsForSale_listInFutureNotNull() {
        final Flux<CarQuickDescriptionDTO> carForSaleDTOFlux = carsForSaleRepo.findAll();

        StepVerifier
                .create(carForSaleDTOFlux)
                .expectSubscription()
                .assertNext((car) -> Assertions.assertThat(car.id).isEqualTo("1"))
                .verifyComplete();
    }

    @Before
    public void putDataInCache() {
        carsForSaleRepo.save(audi).subscribe();
    }

    @SpringBootApplication
    public static class DummyStarter {
    }
}
