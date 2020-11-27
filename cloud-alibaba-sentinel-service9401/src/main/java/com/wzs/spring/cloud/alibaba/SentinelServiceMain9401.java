package com.wzs.spring.cloud.alibaba;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangzhs
 * @since 27/11/2020
 */
@SpringBootApplication
@EnableDiscoveryClient
public class SentinelServiceMain9401 {

    public static void main(String[] args) {
        SpringApplication.run(SentinelServiceMain9401.class, args);
    }

    @RestController
    public class SentinelFlowController {
        @Value("${server.port}")
        private String serverPort;

        @GetMapping("/nacos/get")
        @SentinelResource("hello")
        public String getServerPort() {
            return serverPort;
        }
    }
}
