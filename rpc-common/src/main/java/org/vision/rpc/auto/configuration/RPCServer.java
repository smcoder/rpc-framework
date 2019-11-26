package org.vision.rpc.auto.configuration;

import org.springframework.stereotype.Service;

import java.lang.annotation.*;

/**
 * @author zhiyong.lt
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Service
public @interface RPCServer {
    Class[] value();
}
