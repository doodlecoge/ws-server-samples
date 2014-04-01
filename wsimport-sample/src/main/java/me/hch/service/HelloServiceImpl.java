package me.hch.service;

import javax.jws.WebService;

/**
 * Created by huaiwang on 14-4-1.
 */

@WebService(
        serviceName="CalculatorServiceImpl",
        endpointInterface="me.hch.service.HelloService",
        targetNamespace="http://service.hch.me/")
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String arg0) {
        return "hello * " + arg0;
    }
}
