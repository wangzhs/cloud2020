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
    private final static String PAYMENT_URL = "http://localhost:8001";

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

}
