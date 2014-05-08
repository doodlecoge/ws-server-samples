package me.hch;

import org.springframework.ws.soap.server.endpoint.annotation.FaultCode;
import org.springframework.ws.soap.server.endpoint.annotation.SoapFault;

/**
 * Created by hch on 2014/5/8.
 */
@SoapFault(faultCode = FaultCode.SERVER)
public class EchoException extends Exception {
    public EchoException() {
        super();
    }

    public EchoException(String message) {
        super(message);
    }

    public EchoException(String message, Throwable cause) {
        super(message, cause);
    }

    public EchoException(Throwable cause) {
        super(cause);
    }

    protected EchoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
