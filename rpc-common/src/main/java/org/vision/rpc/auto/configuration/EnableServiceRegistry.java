package org.vision.rpc.auto.configuration;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @author zhiyong.lt
 * */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import(ServiceRegistryAutoConfiguration.class)
public @interface EnableServiceRegistry {
}
