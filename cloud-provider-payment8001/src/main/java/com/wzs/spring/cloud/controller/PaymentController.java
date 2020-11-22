package com.wzs.spring.cloud.controller;

import com.wzs.spring.cloud.entities.CommonResult;
import com.wzs.spring.cloud.entities.Payment;
import com.wzs.spring.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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

    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        log.info("=====插入结果:{}===端口是: {}", i, serverPort);
        return i > 0 ? CommonResult.success(null) : CommonResult.error("error");
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("=====查询结果:{}===端口是: {}", payment, serverPort);
        return null != payment ? CommonResult.success(payment) : CommonResult.error("error");
    }

    @GetMapping("/get/discovery")
    public Object getDiscovery() {
        // 获得服务清单列表
        List<String> services = discoveryClient.getServices();

        List<ServiceInstance> instances = discoveryClient.getInstances(applicationName);
        return this.discoveryClient;
    }

}
