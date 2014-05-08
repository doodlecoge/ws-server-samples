package me.hch;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.ValidationFailureException;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public Element handleEchoRequest(@RequestPayload Element request) throws ParserConfigurationException, EchoException {
        String result = echoService.echo(request.getTextContent());

        Pattern ptn = Pattern.compile("^\\d*$");
        Matcher matcher = ptn.matcher(result);
        if (matcher.find()) {
            // this resolver is configured using annotation
            throw new EchoException("all numbers is not allowed.");
        }

        ptn = Pattern.compile("^[a-zA-Z]*$");
        matcher = ptn.matcher(result);
        if (matcher.find()) {
            // this resolver is configured in spring-ws-servlet.xml
            throw new ValidationFailureException("all alphabets is not allowed.");
        }

        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.newDocument();
        Element element = doc.createElementNS(NAME_SPACE, ECHO_RESPONSE);
        element.setTextContent("response: " + result);

        return element;
    }
}
