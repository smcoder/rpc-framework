package org.vision.rpc.auto.configuration;

import org.springframework.context.annotation.Bean;
import org.vision.rpc.registry.ServiceDiscovery;

/**
 * @author zhiyong.lt
 * */
public class ServiceDiscoveryAutoConfiguration {
    @Bean
    public ServiceDiscovery serviceDiscovery() {
        return new ServiceDiscovery();
    }

    @Bean
    public ConnectionManager connectionManager() {
        return new ConnectionManager();
    }

    @Bean
    public ServiceProxyUtil serviceProxyUtil() {
        return new ServiceProxyUtil();
    }
}
