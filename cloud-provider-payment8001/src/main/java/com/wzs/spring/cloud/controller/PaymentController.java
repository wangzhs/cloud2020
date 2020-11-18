package com.wzs.spring.cloud.controller;

import com.wzs.spring.cloud.entities.CommonResult;
import com.wzs.spring.cloud.entities.Payment;
import com.wzs.spring.cloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
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

    @PostMapping("/create")
    public CommonResult create(Payment payment) {
        int i = paymentService.create(payment);
        log.info("=====插入结果:{}===", i);
        return i > 0 ? CommonResult.success(null) : CommonResult.error("error");
    }

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("=====查询结果:{}===", payment);
        return null != payment ? CommonResult.success(payment) : CommonResult.error("error");
    }

}
