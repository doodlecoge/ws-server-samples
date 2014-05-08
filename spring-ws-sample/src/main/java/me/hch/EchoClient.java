package me.hch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.xml.transform.ResourceSource;
import org.springframework.xml.transform.StringResult;
import org.w3c.dom.DOMImplementation;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.ls.DOMImplementationLS;
import org.w3c.dom.ls.LSSerializer;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Source;
import java.io.IOException;

/**
 * Created by hch on 2014/5/7.
 */
public class EchoClient extends WebServiceGatewaySupport {
    private Resource request;

    public void setRequest(Resource request) {
        this.request = request;
    }

    public void echo() throws IOException {
        Source requestSource = new ResourceSource(request);
        StringResult result = new StringResult();
        getWebServiceTemplate().sendSourceAndReceiveToResult(requestSource, result);
        System.out.println();
        System.out.println(result);
        System.out.println();
    }

    public static void main(String[] args) throws IOException, ParserConfigurationException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/applicationContext.xml", EchoClient.class);
        EchoClient echoClient = (EchoClient) applicationContext.getBean("echoClient");
        echoClient.echo();


        try {
            echoClient.setRequest(makeRequest("123"));
            echoClient.echo();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        try {
            echoClient.setRequest(makeRequest("abc"));
            echoClient.echo();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    public static ByteArrayResource makeRequest(String msg) throws ParserConfigurationException {
        String result = "<EchoRequest xmlns=\"http://hch.me/echo/schemas\">" + msg + "</EchoRequest>";
        return new ByteArrayResource(result.getBytes());
    }
}
