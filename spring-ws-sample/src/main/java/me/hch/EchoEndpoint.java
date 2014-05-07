package me.hch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

/**
 * Created by huaiwang on 14-4-8.
 */
@Endpoint
public class EchoEndpoint {
    private static final String NAME_SPACE = "http://hch.me/echo/schemas";
    private static final String ECHO_REQUEST = "EchoRequest";
    private static final String ECHO_RESPONSE = "EchoResponse";

    private EchoService echoService;

    @Autowired
    public EchoEndpoint(EchoService echoService) {
        this.echoService = echoService;
    }

    @PayloadRoot(
            namespace = NAME_SPACE,
            localPart = ECHO_REQUEST
    )
    @ResponsePayload
    public Element handleEchoRequest(@RequestPayload Element request) throws ParserConfigurationException {
        String result = echoService.echo(request.getTextContent());

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element element = doc.createElementNS(NAME_SPACE, ECHO_RESPONSE);
        element.setTextContent("response: " + result);

        return element;
    }
}
