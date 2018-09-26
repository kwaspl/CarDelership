package com.example.dealership.query.configuration;

import com.example.dealership.query.properties.EnvProperties;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@EnableReactiveMongoRepositories
@EnableConfigurationProperties(EnvProperties.class)
public class MongoReactiveApplication extends AbstractReactiveMongoConfiguration {

    @Autowired
    EnvProperties envProperties;

    @Override
    public MongoClient reactiveMongoClient() {
        System.out.println("############################################");
        return
                MongoClients.create(envProperties.DBConnectionString());
    }

    @Override
    protected String getDatabaseName() {
        return envProperties.carsDBName();
    }
}
