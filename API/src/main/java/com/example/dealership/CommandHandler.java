package com.example.dealership;

import com.example.dealership.commad.domain.admissions.CarAdmissionsService;
import com.example.dealership.commad.datamodel.NewCarDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class CommandHandler {

    @Autowired
    CarAdmissionsService carAdmission;

    public Mono<ServerResponse> addNewCar(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(NewCarDTO.class)
                .map((newCar) -> carAdmission.admitNewCar(newCar))
                .flatMap( (id)->  ServerResponse
                                    .ok()
                                    .contentType(APPLICATION_JSON)
                                    .body(BodyInserters.fromObject(id)))
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

    public Mono<ServerResponse> updateDetailsOfYourOrder(ServerRequest serverRequest) {
        return null;
    }

    public Mono<ServerResponse> cancelYourOrder(ServerRequest serverRequest) {
        return null;
    }
}
