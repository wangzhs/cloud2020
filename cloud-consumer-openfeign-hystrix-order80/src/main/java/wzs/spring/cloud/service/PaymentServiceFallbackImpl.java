package wzs.spring.cloud.service;

import org.springframework.stereotype.Component;

/**
 * @author wangzhs
 * @since 24/11/2020
 */
@Component
public class PaymentServiceFallbackImpl implements PaymentService {
    @Override
    public String paymentHystrixTimeOk() {
        return Thread.currentThread().getName() + "fallback";
    }

    @Override
    public String paymentHystrixTimeOut() {
        return Thread.currentThread().getName() + "fallback";
    }
}
