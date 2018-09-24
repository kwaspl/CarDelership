package com.example.dealership;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CarsController {

    @Autowired
    QueryHandler queryHandler;

    @Autowired
    CommandHandler commandHandler;

    @Bean
    public RouterFunction<ServerResponse> route() {

        return RouterFunctions
                .route(GET("/cars") ,queryHandler::getCarsForSale)
                .andRoute(GET("/car/{id}") ,queryHandler::getDetailsOfTheCar)
                .andRoute(POST("/car"), commandHandler::addNewCar)
                .andRoute(PATCH("/car/{id}"), commandHandler::updateCarOffer)
                .andRoute(DELETE("/car/{id}"), commandHandler::takeCarOffTheMarket)
                .andRoute(POST("/order"), commandHandler::buyThatCar)
                .andRoute(PATCH("/order"), commandHandler::updateDetailsOfYourOrder)
                .andRoute(DELETE("/order"), commandHandler::cancelYourOrder)
                ;
    }
}
