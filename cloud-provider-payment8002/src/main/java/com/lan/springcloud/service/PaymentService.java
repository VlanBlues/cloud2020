package com.lan.springcloud.service;

import com.lan.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @author Vlan
 * @date 2020/7/2
 */

public interface PaymentService {
    int create(Payment payment);
    Payment getPaymentById(int id);
}
