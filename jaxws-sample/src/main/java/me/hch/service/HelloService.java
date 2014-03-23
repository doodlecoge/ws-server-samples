package me.hch.service;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Created by hch on 2014/3/23.
 */
@WebService
//@SOAPBinding(style = SOAPBinding.Style.RPC)
@SOAPBinding(style = SOAPBinding.Style.DOCUMENT)
public interface HelloService {
    public String hello(String who);
}
