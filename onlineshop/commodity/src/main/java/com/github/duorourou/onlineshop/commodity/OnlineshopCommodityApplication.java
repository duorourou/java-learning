package com.github.duorourou.onlineshop.commodity;

import brave.sampler.Sampler;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableDiscoveryClient
@EnableWebFlux
@EnableReactiveMongoRepositories
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
@EnableCircuitBreaker
@EnableAsync
public class OnlineshopCommodityApplication {

    @Value("${spring.sleuth.web.skip-pattern}")
    private String skipPattern;

    public static void main(String[] args) {
        SpringApplication.run(OnlineshopCommodityApplication.class, args);
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
