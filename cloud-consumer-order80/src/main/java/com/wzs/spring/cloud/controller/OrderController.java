package com.wzs.spring.cloud.controller;

import com.wzs.spring.cloud.entities.CommonResult;
import com.wzs.spring.cloud.entities.Payment;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author wangzhs
 * @since 18/11/2020
 */
@RestController
@RequestMapping("order")
public class OrderController {

//    private final static String PAYMENT_URL = "http://localhost:8001";
    private final static String PAYMENT_URL = "http://CLOUD-PROVIDER-PAYMENT";

    @Resource
    private RestTemplate restTemplate;

    @PostMapping("/create")
    public CommonResult create(Payment payment) {
        return restTemplate.postForObject(String.format("%s/payment/create", PAYMENT_URL), payment, CommonResult.class);
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForObject(String.format("%s/payment/get/%s", PAYMENT_URL, id), CommonResult.class);
    }

    @GetMapping("/get/discovery")
    public Object getDiscovery() {
        // 获得服务清单列表
        return restTemplate.getForObject(String.format("%s/payment/get/discovery", PAYMENT_URL), Object.class);
    }

    @GetMapping("/get/entity/{id}")
    public Object getEntityPaymentById(@PathVariable("id") Long id) {
        return restTemplate.getForEntity(String.format("%s/payment/get/%s", PAYMENT_URL, id), Object.class);
    }

}
