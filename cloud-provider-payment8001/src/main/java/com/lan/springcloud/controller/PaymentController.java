package com.lan.springcloud.controller;

import com.lan.springcloud.entities.CommonResult;
import com.lan.springcloud.entities.Payment;
import com.lan.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Vlan
 * @date 2020/7/1
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;
    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @RequestMapping("/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") int id) {
        Payment paymentById = paymentService.getPaymentById(id);
        System.out.println("data:" + paymentById);
        if (paymentById != null) {
            return new CommonResult<>(200, "获取成功,serverPort:" + serverPort, paymentById);
        } else {
            return new CommonResult<>(444, "获取失败");
        }
    }

    @PostMapping("/payment/create")
    public CommonResult<Integer> create(@RequestBody Payment payment) {
        int i = paymentService.create(payment);
        if (i > 0) {
            return new CommonResult<>(200, "插入成功,serverPort:" + serverPort, i);

        } else {
            return new CommonResult<>(444, "插入失败");
        }
    }

    @GetMapping("/payment/discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("*****element:"+service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("*****instances"+instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }

        return this.discoveryClient;
    }
}
