package me.hch;

import me.hch.service.HelloService;
import me.hch.service.HelloServiceImplService;

import javax.xml.namespace.QName;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by huaiwang on 14-4-1.
 */
public class WsClient {
    public static void main(String[] args) throws MalformedURLException {
        String wsdlLoc = "http://127.0.0.1:8088/hellob?wsdl";
        String ns = "http://service.hch.me/";
        String serviceName = "CalculatorServiceImpl";

        // do not use no arguments constructor
        // pass wsdl location, namespace and service name manully
        HelloServiceImplService s = new HelloServiceImplService(
                new URL(wsdlLoc), new QName(ns, serviceName)
        );
        HelloService p = s.getHelloServiceImplPort();
        String hch = p.hello("hch");

        System.out.println(hch);
    }
}
