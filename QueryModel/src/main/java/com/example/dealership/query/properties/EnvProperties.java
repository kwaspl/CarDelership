package com.example.dealership.query.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix="env")
public class EnvProperties {

    private String hazelcastname;
    private String carCacheName;

    public String getHazelcastname() {
        return hazelcastname;
    }

    public void setHazelcastname(String hazelcastname) {
        this.hazelcastname = hazelcastname;
    }

    public String getCarCacheName() {
        return carCacheName;
    }

    public void setCarCacheName(String carCacheName) {
        this.carCacheName = carCacheName;
    }
}
