package wzs.spring.cloud.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author wangzhs
 * @since 23/11/2020
 */
@Component
@FeignClient(value = "cloud-provider-hystrix-payment", path = "/payment")
public interface PaymentService {

    @GetMapping("/hystrix/ok")
    public String paymentHystrixTimeOk();

    @GetMapping("/hystrix/timeout")
    public String paymentHystrixTimeOut();

}
