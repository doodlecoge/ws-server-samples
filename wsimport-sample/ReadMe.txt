Contract First Web Service
==========================

1. create wsdl

    In this example we use wsdl generated from jaxws-sample.
    We simply save contents of the following two links to file,
    and modify xsd import in the wsdl file to the saved xsd file
    instead of original url (http://localhost:8080/hello?xsd=1).
    We have a copy of these two files in WEB-INF directory.

        hello.wsdl
            http://localhost:8080/hello?wsdl

        hello.xsd
            http://localhost:8080/hello?xsd=1

2. use wsimport to generate jax-ws artifacts

    a. cd to WEB-INF directory where you save wsdl & xsd files
    b. wsimport -keep hello.wsdl, and will generate
       the following source files

        package-name/
            - Hello.java
            - HelloResponse.java
            - HelloService.java
            - HelloServiceImplService.java
            - ObjectFactory.java
            - package-info.java

       only "HelloService.java", so called SEI, is needed
       to create the web service.

3. create SIB "HelloServiceImpl" class that implements
   "HelloService" interface. And append @WebService
   with serviceName, endpointInterface and targetNamespace
   set to appropriate values.

4. publish web service,

        Endpoint.publish(
            "http://127.0.0.1:8088/hellob",
            new HelloServiceImpl()
        );



Create Web Service Client
=========================


1. use generated artifacts from previous section,
   only "HelloServiceImplService.java" is needed

        see "WsClient" class and inline comments,
        and also "HelloServiceImplService.java".


   It's RECOMMENDED to regenerate these artifacts
   from newly published wsdl.