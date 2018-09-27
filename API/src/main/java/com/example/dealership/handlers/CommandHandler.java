package com.example.dealership.handlers;

import com.example.dealership.commad.domain.admissions.CarOfferAdmissionsService;
import com.example.dealership.commad.datamodel.NewCarOfferDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.web.reactive.function.BodyInserters.fromObject;

@Component
public class CommandHandler {

    @Autowired
    CarOfferAdmissionsService carOfferAdmissionsService;

    public Mono<ServerResponse> addNewCarOffer(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(NewCarOfferDTO.class)
                .map((newCar) -> carOfferAdmissionsService.admitNewCarOffer(newCar))
                .flatMap( (carId)->  ServerResponse
                                    .ok()
                                    .contentType(APPLICATION_JSON)
                                    .body(fromObject(carId)))
                ;
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

}
