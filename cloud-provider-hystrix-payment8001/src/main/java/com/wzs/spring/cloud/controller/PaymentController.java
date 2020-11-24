package com.wzs.spring.cloud.controller;

import com.wzs.spring.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author wangzhs
 * @since 18/11/2020
 */
@Slf4j
@RestController
@RequestMapping("payment")
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Resource
    private DiscoveryClient discoveryClient;

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.application.name}")
    private String applicationName;

    private AtomicInteger integer = new AtomicInteger(0);

    @GetMapping("/hystrix/ok")
    public String paymentHystrixOk() throws InterruptedException {
        return Thread.currentThread().getName();
    }

    @GetMapping("/hystrix/timeout")
    public String paymentHystrixTimeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(3);
        integer.incrementAndGet();
        log.info("请求第{}次", integer.get());
        return Thread.currentThread().getName();
    }

}
