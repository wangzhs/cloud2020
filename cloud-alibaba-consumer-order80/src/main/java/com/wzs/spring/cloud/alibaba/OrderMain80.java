package com.wzs.spring.cloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wangzhs
 * @since 26/11/2020
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderMain80 {
    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }

    @RestController
    public class TestController {

        @Resource
        private RestTemplate restTemplate;

        @GetMapping(value = "/order/get")
        public String getServerPort() {
            return restTemplate.getForObject("http://cloud-alibaba-provider-paymeny/nacos/get", String.class);
        }
    }

}
