package com.wzs.spring.cloud.alibaba;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangzhs
 * @since 26/11/2020
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain9001.class, args);
    }

    @RestController
    public class PaymentController {
        @Value("${server.port}")
        private String serverPort;

        @GetMapping("/nacos/get")
        public String getServerPort() {
            return serverPort;
        }


    }
}
