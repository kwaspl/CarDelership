package com.example.dealership;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.*;

@Configuration
public class CarsController {

    @Bean
    public RouterFunction<ServerResponse> route(QueryHandler queryHandler) {

        return RouterFunctions
                .route(GET("/cars") ,queryHandler::getCarsForSale)
                .andRoute(POST("/car"), queryHandler::getCarsForSale)
                .andRoute(PATCH("/car"), queryHandler::getCarsForSale)
                .andRoute(DELETE("/car"), queryHandler::getCarsForSale)
                .andRoute(POST("/order"), queryHandler::getCarsForSale)
                .andRoute(PATCH("/order"), queryHandler::getCarsForSale)
                .andRoute(DELETE("/order"), queryHandler::getCarsForSale)
                ;
    }
}
