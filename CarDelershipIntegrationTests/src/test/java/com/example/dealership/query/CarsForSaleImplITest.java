package com.example.dealership.query;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest("env.hazelcastname=cluster-name")
public class CarsForSaleImplITest {

    @Autowired
    private CarsForSale carsForSale;

    @SpringBootApplication
    static class TestConfiguration {
    }

}