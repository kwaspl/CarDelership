package com.example.dealership.query;

import com.example.dealership.query.datamodel.CarForSaleDTO;
import com.example.dealership.query.repo.CarsForSaleRepo;
import com.hazelcast.cache.ICache;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.ExecutionException;

import static java.util.Collections.emptyList;
import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest({"env.hazelcastname=cluster-name", "env.carCacheName=thisisus"})
public class CarsForSaleRepoImplITest {

    @Autowired
    CarsForSaleRepo repo;

    @Test
    public void fetchCarsForSale_returnNonNullObject(){
        assertThat(repo.fetchCarsForSale()).isNotNull();
    }

    @Test
    public void fetchCarsForSale_listInFutureNotNull() throws ExecutionException, InterruptedException {
        assertThat(repo.fetchCarsForSale().get()).isNotNull();
    }

    @Before
    public void putDataInCache(){
        HazelcastInstance instance = Hazelcast.getHazelcastInstanceByName("cluster-name");
        final ICache<String, List<CarForSaleDTO>> thisisus = instance.getCacheManager().getCache("thisisus");
        thisisus.put("cars", emptyList());
    }

    @SpringBootApplication
    @EnableCaching
    static class SpringConfiguration {}

}