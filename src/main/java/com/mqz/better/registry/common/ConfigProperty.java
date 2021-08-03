package com.mqz.better.registry.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 *  版权所有 © Copyright 2012<br>
 *
 * @Author： 蒙大拿
 * @Date：
 * @Description
 * @About： https://github.com/DemoMeng
 */
@Data
@Configuration
public class ConfigProperty {

    @Value("${docker.registry.url:http://192.168.2.11:5040/v2/_catelog}")
    private String registryUrl;

    @Value("${docker.registry.port:5040}")
    private String port;

}
