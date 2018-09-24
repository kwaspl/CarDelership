package com.example.dealership.query.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="env")
public class EnvProperties {

    private String carsDbName;
    private String dbConnectionString;

    public String carsDBName() {
        return carsDbName;
    }


    public String DBConnectionString() {
        return dbConnectionString;
    }
}
