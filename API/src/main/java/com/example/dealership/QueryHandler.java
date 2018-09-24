package com.example.dealership;

import com.example.dealership.query.CarsForSale;
import com.example.dealership.query.datamodel.CarDetailsDTO;
import com.example.dealership.query.datamodel.CarQuickDescriptionDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromPublisher;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Component
public class QueryHandler {

    @Autowired
    CarsForSale carsForSale;

    public Mono<ServerResponse> getCarsForSale(ServerRequest request) {
        return  ok()
                .contentType(APPLICATION_JSON)
                .body(fromPublisher(carsForSale.carsForSale(), CarQuickDescriptionDTO.class));
    }

    public Mono<ServerResponse> getDetailsOfTheCar(ServerRequest serverRequest) {
        final Mono<CarDetailsDTO> carDetails = carsForSale.carDetails(serverRequest.pathVariable("id"));
        return ok()
                .contentType(APPLICATION_JSON)
                .body(fromPublisher(carDetails, CarDetailsDTO.class));
    }
}
