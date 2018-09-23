package com.example.dealership.query.configuration;

import com.example.dealership.query.properties.EnvProperties;
import com.hazelcast.config.CacheSimpleConfig;
import com.hazelcast.config.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static java.util.Map.of;

@Configuration
@EnableConfigurationProperties(EnvProperties.class)
public class CarCacheConfiguration {

    @Autowired
    EnvProperties properties;

    @Bean
    public Config createCacheConfig(){
        CacheSimpleConfig cacheConfig = new CacheSimpleConfig();
        cacheConfig.setName(properties.getCarCacheName());
        final Map<String, CacheSimpleConfig> configurationOfCaches = of(properties.getCarCacheName(), cacheConfig);

        return new Config().setInstanceName(properties.getHazelcastname()).setCacheConfigs(configurationOfCaches);
    }


}
