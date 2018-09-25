package com.example.dealership;

import com.example.dealership.query.CarsForSale;
import com.example.dealership.query.datamodel.CarQuickDescriptionDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {CarsController.class, QueryHandler.class, CommandHandler.class})
@WebFluxTest
public class CarsControllerITest {

    @Autowired
    private ApplicationContext context;

    @MockBean(name="carsForSale")
    private CarsForSale carsForSale;

    private WebTestClient webClient;

    @Test
    public void cars_correctResponseIsReturned() throws Exception {
        webClient = WebTestClient.bindToApplicationContext(context).build();

                webClient
                .get().uri("/cars")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(CarQuickDescriptionDTO.class)
                .hasSize(0);
    }

}
