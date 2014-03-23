package me.hch.service;

import javax.jws.WebService;

/**
 * Created by hch on 2014/3/23.
 */
@WebService(endpointInterface = "me.hch.service.HelloService")
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String who) {
        return "Hello " + who + "!";
    }
}
