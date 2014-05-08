Steps to Create Spring Web Service
==================================

1.  Contract first, create XSD file (echo.xsd) for the
    messages you are going to send;

2.  Write service interface (EchoService) and service
    implementation (EchoServiceImpl) classes,
    and annotate the service implementation with
    'org.springframework.stereotype.Service';

3.  Write service endpoint class (EchoEndpoint);

    1.  annotate service endpoint class with
        **org.springframework.ws.server.endpoint.annotation.Endpoint**;
    2.  **@Autowire** the service defined in step 2 at an appropriate place;
    3.  use **@org.springframework.ws.server.endpoint.annotation.PayloadRoot**
        to indicate which sort of message to handle by the annotated method.

4.  generate wsdl using the following config in spring-ws-servlet.xml;

        <sws:dynamic-wsdl id="holiday"
            portTypeName="HumanResource"
            locationUri="/holidayService/"
            targetNamespace="http://mycompany.com/hr/definitions">
          <sws:xsd location="/WEB-INF/hr.xsd"/>
        </sws:dynamic-wsdl>

5.  dependencies used:

        <dependencies>
            <dependency>
                <groupId>org.springframework.ws</groupId>
                <artifactId>spring-ws-core</artifactId>
                <version>2.1.4.RELEASE</version>
            </dependency>
        </dependencies>


> **Note:** don't forget
> <context:component-scan base-package="me.hch"/>,
> or you are going to have 404 error when running
> the web service client.