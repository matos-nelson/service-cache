package com.cache.demo.service_cache.configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.MapConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookCacheClient {

    public static final String BookMap = "book";

    @Bean
    public Config hazelCastConfig() {
        return new Config()
            .setInstanceName("hazelcast-instance")
            .addMapConfig(
                new MapConfig()
                    .setName(BookMap)
                    .setMaxIdleSeconds(20)
                    .setTimeToLiveSeconds(360));
    }
}
