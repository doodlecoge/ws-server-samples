import me.hch.service.HelloService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by hch on 2014/6/8.
 */
public class JaxWsClient {
    public static void main(String[] args) throws MalformedURLException {

        String ns = "http://service.hch.me/";
        String serviceName = "HelloServiceImplService";
        String url = "http://localhost:8080/hello?wsdl";

//        String ns = "http://hch.me/echo/definitions";
//        String serviceName = "EchoPortTypeService";
//        String url = "http://localhost:8080/echo.wsdl";

        Service service = Service.create(
                new URL(url),
                new QName(ns, serviceName)
        );

        QName serviceName1 = service.getServiceName();
        System.out.println(serviceName1);

        HelloService p = service.getPort(HelloService.class);

        String greeting = p.hello("huaichao");
        System.out.println(greeting);
    }
}
