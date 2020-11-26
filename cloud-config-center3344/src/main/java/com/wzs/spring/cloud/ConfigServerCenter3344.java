package com.wzs.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author wangzhs
 * @since 25/11/2020
 */
@SpringBootApplication
@EnableConfigServer /*刷新需要 curl -XPOST "http://config-3344.com:3344/actuator/bus-refresh"*/
public class ConfigServerCenter3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerCenter3344.class, args);
    }
}
