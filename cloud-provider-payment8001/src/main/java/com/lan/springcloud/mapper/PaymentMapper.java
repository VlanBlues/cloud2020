package com.lan.springcloud.mapper;

import com.lan.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Vlan
 * @date 2020/7/1
 */
public interface PaymentMapper {
    int create(Payment payment);
    Payment getPaymentById(@Param("id") int id);
}
