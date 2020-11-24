package com.wzs.spring.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
        return Thread.currentThread().getName() + "ok";
    }

    /**
     * fallbackMethod 指定当前方法异常了调用什么方法
     * HystrixProperty 服务超时时间，单位毫秒
     * @return
     * @throws InterruptedException
     */
    @GetMapping("/hystrix/timeout")
    @HystrixCommand(fallbackMethod = "paymentHystrixOk",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentHystrixTimeOut() throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        integer.incrementAndGet();
        log.info("请求第{}次", integer.get());
        return Thread.currentThread().getName() + "timeout";
    }

}
