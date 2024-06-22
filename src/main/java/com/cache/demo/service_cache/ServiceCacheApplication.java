package com.cache.demo.service_cache;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class ServiceCacheApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCacheApplication.class, args);
    }

}
