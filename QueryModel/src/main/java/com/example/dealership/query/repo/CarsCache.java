package com.example.dealership.query.repo;

import com.example.dealership.query.datamodel.CarForSaleDTO;
import com.example.dealership.query.properties.EnvProperties;
import com.hazelcast.cache.ICache;
import com.hazelcast.core.*;
import org.reactivestreams.Publisher;
import org.reactivestreams.Subscriber;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import reactor.core.publisher.BaseSubscriber;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Consumer;

@Component
@EnableConfigurationProperties(EnvProperties.class)
public class CarsCache implements Publisher<List<CarForSaleDTO>>, ExecutionCallback<List<CarForSaleDTO>> {

    @Autowired
    EnvProperties properties;

    private HazelcastInstance instance;

    private Subscriber<? super List<CarForSaleDTO>> subscriber;

    @EventListener(ApplicationReadyEvent.class)
    void setCache(){
        instance = Hazelcast.getHazelcastInstanceByName(properties.getHazelcastname());
    }

    public Flux<List<CarForSaleDTO>> get(){
        return Flux.from(this);
    }

    @Override
    public void onResponse(List<CarForSaleDTO> carForSaleDTO) {
        subscriber.onNext(carForSaleDTO);
        subscriber.onComplete();
    }

    @Override
    public void onFailure(Throwable throwable) {
        subscriber.onError(throwable);
    }

    @Override
    public void subscribe(Subscriber<? super List<CarForSaleDTO>> subscriber) {
        this.subscriber = subscriber;
        subscriber.onSubscribe(new BaseSubscriber<>() {});
        final ICache<String, List<CarForSaleDTO>> cache = instance.getCacheManager().getCache(properties.getCarCacheName());
        cache.getAsync("cars")
             .andThen(this);
    }

}
