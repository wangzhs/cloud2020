package com.wzs.spring.cloud.service;

import com.wzs.spring.cloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangzhs
 * @since 18/11/2020
 */
public interface PaymentService {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
