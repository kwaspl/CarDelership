package com.example.dealership;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class CommandHandler {

    public Mono<ServerResponse> addNewCar(ServerRequest serverRequest) {
        return null;
    }

    public Mono<ServerResponse> updateCarOffer(ServerRequest serverRequest) {
        return null;
    }

    public Mono<ServerResponse> takeCarOffTheMarket(ServerRequest serverRequest) {
        return null;
    }

    public Mono<ServerResponse> buyThatCar(ServerRequest serverRequest) {
        return null;
    }

    public Mono<ServerResponse> updateDetailsOfYourOrder(ServerRequest serverRequest) {
        return null;
    }

    public Mono<ServerResponse> cancelYourOrder(ServerRequest serverRequest) {
        return null;
    }
}
