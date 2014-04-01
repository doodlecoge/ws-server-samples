package me.hch;

import me.hch.service.HelloServiceImpl;

import javax.xml.ws.Endpoint;

/**
 * Created by huaiwang on 14-4-1.
 */
public class PublishWebService {
    public static void main(String[] args) {
        Endpoint.publish("http://127.0.0.1:8088/hellob", new HelloServiceImpl());
    }
}
