package com.wzs.spring.cloud.controller;

import com.wzs.spring.cloud.entities.CommonResult;
import com.wzs.spring.cloud.entities.Payment;
import com.wzs.spring.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    @Value("${server.port}")
    private String serverPort;

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
        return null != payment ? CommonResult.success(payment, serverPort) : CommonResult.error("error");
    }

}
