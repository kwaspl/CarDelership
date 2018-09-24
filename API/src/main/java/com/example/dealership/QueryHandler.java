package com.example.dealership;

import com.example.dealership.query.CarsForSale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class QueryHandler {

    @Autowired
    CarsForSale carsForSale;

    public Mono<ServerResponse> getCarsForSale(ServerRequest request) {
        System.out.println(carsForSale.carsForSale());

        return ServerResponse
                .ok()
                .contentType(MediaType.TEXT_PLAIN)
                .body(fromObject("Hello, Spring!"));
    }
}
