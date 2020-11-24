package wzs.spring.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "paymentHystrixTimeOutHandle", commandProperties = {
        @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds", value = "8000")
})
public class OrderController {

    @Resource
    private PaymentService paymentService;

    @GetMapping("/hystrix/ok")
    public String paymentHystrixTimeOk() {
        return paymentService.paymentHystrixTimeOk();
    }

    @GetMapping("/hystrix/timeout")
    @HystrixCommand
    public String paymentHystrixTimeOut() throws InterruptedException {
        // 测试超时
        return paymentService.paymentHystrixTimeOut();
    }

    public String paymentHystrixTimeOutHandle() throws InterruptedException {
        // 测试超时
        return Thread.currentThread().getName() + "error";
    }
}
