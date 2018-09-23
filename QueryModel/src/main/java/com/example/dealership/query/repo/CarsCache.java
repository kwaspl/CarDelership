package com.example.dealership.query.repo;

import com.example.dealership.query.datamodel.CarForSaleDTO;
import com.example.dealership.query.properties.EnvProperties;
import com.hazelcast.cache.ICache;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.ICompletableFuture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.Future;

@Component
@EnableConfigurationProperties(EnvProperties.class)
public class CarsCache {

    @Autowired
    EnvProperties properties;

    private HazelcastInstance instance;

    @EventListener(ApplicationReadyEvent.class)
    void setCache(){
        instance = Hazelcast.getHazelcastInstanceByName(properties.getHazelcastname());
    }

    public Future<List<CarForSaleDTO>> get(){
        final ICache<String, List<CarForSaleDTO>> cache = instance.getCacheManager().getCache(properties.getCarCacheName());
        final ICompletableFuture<List<CarForSaleDTO>> async = cache.getAsync("");
        async.
        return cache.getAsync("cars");
    }

}
