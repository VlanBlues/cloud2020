package com.lan.springcloud.controller;

import com.lan.springcloud.entities.CommonResult;
import com.lan.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author Vlan
 * @date 2020/7/2
 */
@RestController
@Slf4j
public class OrderController {
//    public static final String PAYMENT_RUL = "http://localhost:8001";
    public static final String PAYMENT_RUL = "http://cloud-payment-service";
    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/create")
    public CommonResult create(Payment payment){
        return restTemplate.postForObject(PAYMENT_RUL+"/payment/create",payment,CommonResult.class);

    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") int id){
        return restTemplate.getForObject(PAYMENT_RUL+"/payment/get/"+id,CommonResult.class);
    }
}

