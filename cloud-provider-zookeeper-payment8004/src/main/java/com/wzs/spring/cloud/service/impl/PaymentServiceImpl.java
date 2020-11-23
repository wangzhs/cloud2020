package com.wzs.spring.cloud.service.impl;

import com.wzs.spring.cloud.dao.PaymentDao;
import com.wzs.spring.cloud.entities.Payment;
import com.wzs.spring.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangzhs
 * @since 18/11/2020
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }

}
