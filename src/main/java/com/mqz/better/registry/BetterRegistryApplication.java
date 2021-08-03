package com.mqz.better.registry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.mqz.better.registry.**.**"})
public class BetterRegistryApplication {

    public static void main(String[] args) {
        SpringApplication.run(BetterRegistryApplication.class, args);
    }

}
