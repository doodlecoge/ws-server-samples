package me.hch;

import org.springframework.stereotype.Service;

/**
 * Created by huaiwang on 14-4-8.
 */
@Service
public class EchoServiceImpl implements EchoService {
    public String echo(String msg) {
        return msg;
    }
}
