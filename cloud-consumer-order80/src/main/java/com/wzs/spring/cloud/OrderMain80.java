package com.wzs.spring.cloud;

import com.wzs.myrule.MySelfRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

/**
 * @author wangzhs
 * @since 18/11/2020
 */
@SpringBootApplication
@EnableEurekaClient
@RibbonClient(name = "cloud-provider-payment", configuration = MySelfRuleConfig.class)
public class OrderMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderMain80.class, args);
    }
}
