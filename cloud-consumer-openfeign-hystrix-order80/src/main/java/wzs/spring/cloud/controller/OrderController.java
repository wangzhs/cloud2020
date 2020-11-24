package wzs.spring.cloud.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import wzs.spring.cloud.service.PaymentService;

import javax.annotation.Resource;

/**
 * @author wangzhs
 * @since 18/11/2020
 */
@RestController
@RequestMapping("order")
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/hystrix/ok")
    public String paymentHystrixTimeOk() {
        return paymentService.paymentHystrixTimeOk();
    }

    @GetMapping("/hystrix/timeout")
    public String paymentHystrixTimeOut() throws InterruptedException {
        // 测试超时
        return paymentService.paymentHystrixTimeOut();
    }
}
