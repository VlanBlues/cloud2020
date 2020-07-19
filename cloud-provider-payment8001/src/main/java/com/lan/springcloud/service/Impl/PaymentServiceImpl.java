package com.lan.springcloud.service.Impl;

import com.lan.springcloud.entities.Payment;
import com.lan.springcloud.mapper.PaymentMapper;
import com.lan.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Vlan
 * @date 2020/7/2
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentMapper paymentMapper;
    @Override
    public int create(Payment payment) {

        return paymentMapper.create(payment);
    }

    @Override
    public Payment getPaymentById(int id) {
        return paymentMapper.getPaymentById(id);
    }
}
