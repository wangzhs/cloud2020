package com.wzs.spring.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.concurrent.TimeUnit;

/**
 * @author wangzhs
 * @since 26/11/2020
 */
@SpringBootApplication
@EnableDiscoveryClient
@RefreshScope
public class ConfigNacosMain3377 {
    public static void main(String[] args) throws InterruptedException {
        ConfigurableApplicationContext run = SpringApplication.run(ConfigNacosMain3377.class, args);
        while (true) {
            System.out.println(run.getEnvironment().getProperty("config.info"));
            TimeUnit.SECONDS.sleep(3);
        }
    }
}
