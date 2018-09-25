package com.example.dealership;

import com.example.dealership.query.CarsForSale;
import com.example.dealership.query.datamodel.CarQuickDescriptionDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

import java.util.Arrays;

import static org.mockito.Mockito.when;
import static reactor.core.publisher.Flux.fromIterable;

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

        final Flux<CarQuickDescriptionDTO> audi = fromIterable(Arrays.asList(new CarQuickDescriptionDTO("1", "audi")));

        when(carsForSale.carsForSale()).thenReturn(audi);

        webClient
                .get().uri("/cars")
                .accept(MediaType.APPLICATION_JSON)
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(CarQuickDescriptionDTO.class)
                .hasSize(1);
    }

}
