package me.hch;

import org.jdom.Element;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;

/**
 * Created by huaiwang on 14-4-8.
 */
@Endpoint
public class EchoEndpoint {
    private EchoService echoService;

    @Autowired
    public EchoEndpoint(EchoService es) {
        this.echoService = es;
    }

    @PayloadRoot(
            namespace = "http://hch.me/echo/schemas",
            localPart = "EchoRequest"
    )
    public void handleEchoRequest(@RequestPayload Element echoRequest) {
        System.out.println(echoRequest.toString());
    }
}
