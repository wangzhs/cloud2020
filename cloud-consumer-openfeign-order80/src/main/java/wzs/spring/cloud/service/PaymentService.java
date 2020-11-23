package wzs.spring.cloud.service;

import com.wzs.spring.cloud.entities.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author wangzhs
 * @since 23/11/2020
 */
@Component
// value 调取服务的applicationName path类似于 提取共有的url路径
@FeignClient(value = "cloud-provider-payment", path = "/payment")
public interface PaymentService {

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    @GetMapping("/openfeign/timeout")
    public String paymentTimeOut();

}
