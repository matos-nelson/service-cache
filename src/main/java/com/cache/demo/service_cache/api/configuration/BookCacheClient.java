package com.cache.demo.service_cache.api.configuration;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.client.config.ClientNetworkConfig;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BookCacheClient {

    public static final String BookMap = "book";

    @Bean
    public ClientConfig clientConfig() {
        ClientConfig clientConfig = new ClientConfig();
        clientConfig.setClusterName(BookMap);
        ClientNetworkConfig networkConfig = clientConfig.getNetworkConfig();
        networkConfig
            //.addAddress("192.168.1.12:5701", "192.168.1.13:5701")
            .setSmartRouting(true)
            .addOutboundPortDefinition("34700-34710")
            .setRedoOperation(true)
            .setConnectionTimeout(5000);

        return clientConfig;
    }

    @Bean
    public HazelcastInstance hazelcastInstance(ClientConfig clientConfig) {
        return HazelcastClient.newHazelcastClient(clientConfig);
    }
}
