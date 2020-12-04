package com.gzdata.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mongodb.MongoClientOptions;

@Configuration
public class MongoDbSettings {

    @Bean
    public MongoClientOptions mongoOptions() {
        return MongoClientOptions
            .builder()
            .maxConnectionIdleTime(60000)
            .build();
    }

}
