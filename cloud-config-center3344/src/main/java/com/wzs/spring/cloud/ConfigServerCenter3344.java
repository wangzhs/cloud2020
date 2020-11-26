package com.wzs.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * @author wangzhs
 * @since 25/11/2020
 */

/**
 * 刷新需要 curl -XPOST "http://config-3344.com:3344/actuator/bus-refresh"
 * 定点通知 ：curl -XPOST "http://config-3344.com:3344/actuator/bus-refresh/cloud-config-server-center:3355"
 */
@SpringBootApplication
@EnableConfigServer
public class ConfigServerCenter3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigServerCenter3344.class, args);
    }
}
