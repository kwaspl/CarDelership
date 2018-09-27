package com.example.dealership.query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CarsOffersImplTest {

    @InjectMocks
    CarOffersImpl carsForSale;

    @Test
    public void carsForSale_returnedListNotNull(){
        assertThat(carsForSale.availableOffers()).isNotNull();
    }

}
