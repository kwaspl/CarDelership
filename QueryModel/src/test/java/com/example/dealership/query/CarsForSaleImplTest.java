package com.example.dealership.query;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(MockitoJUnitRunner.class)
public class CarsForSaleImplTest {

    public static final String EMPTY_STRING = "";
    @InjectMocks
    CarsForSaleImpl carsForSale;

    @Test
    public void carsForSale_returnedListNotNull(){
        assertThat(carsForSale.carsForSale()).isNotNull();
    }

    @Test
    public void carsForSaleFavoredByTheUser_returnListNotNullForTheDefaultValues(){
        assertThat(carsForSale.carsForSaleFavoredByTheUser(EMPTY_STRING)).isNotNull();
    }

    @Test
    public void carsForSaleOfMake_returnListNotNullForTheDefaultValues(){
        assertThat(carsForSale.carsForSaleOfMake(EMPTY_STRING)).isNotNull();
    }


}
