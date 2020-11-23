package wzs.spring.cloud.controller;

import com.wzs.spring.cloud.entities.CommonResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping("/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        return paymentService.getPaymentById(id);
    }

}
