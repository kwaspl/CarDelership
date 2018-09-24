package com.example.dealership.query;

import com.example.dealership.query.datamodel.CarForSaleDTO;
import com.example.dealership.query.repo.CarsForSaleRepo;
import com.hazelcast.cache.ICache;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ISet;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;
import reactor.core.Disposable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest({"env.hazelcastname=cluster-name", "env.carCacheName=thisisus"})
public class CarsForSaleRepoImplITest {

    public static final CarForSaleDTO car = new CarForSaleDTO("audi");


    @Autowired
    CarsForSaleRepo repo;

    @Test
    public void fetchCarsForSale_returnNonNullObject(){
        assertThat(repo.fetchCarsForSale()).isNotNull();
    }

    @Test
    public void fetchCarsForSale_listInFutureNotNull() throws ExecutionException, InterruptedException {
        final Flux<List<CarForSaleDTO>> carForSaleDTOFlux = repo.fetchCarsForSale();

        StepVerifier
                .create(carForSaleDTOFlux)
                .expectSubscription()
                .assertNext( (cars) -> Assertions.assertThat(cars).hasSize(1))
                .verifyComplete();

    }

    public <T> Flux<T> appendBoomError(Flux<T> source) {
        return source.concatWith(Mono.error(new IllegalArgumentException("boom")));
    }

    @Before
    public void putDataInCache(){
        HazelcastInstance instance = Hazelcast.getHazelcastInstanceByName("cluster-name");
        final ICache<String, List<CarForSaleDTO>> thisisus = instance.getCacheManager().getCache("thisisus");
        thisisus.put("cars", asList(car));
    }

    @SpringBootApplication
    @EnableCaching
    static class SpringConfiguration {}

}