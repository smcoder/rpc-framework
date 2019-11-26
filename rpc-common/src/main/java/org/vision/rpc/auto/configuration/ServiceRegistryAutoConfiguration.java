package org.vision.rpc.auto.configuration;

import org.springframework.context.annotation.Bean;
import org.vision.rpc.registry.ServiceRegistry;

/**
 * @author zhiyong.lt
 * */
public class ServiceRegistryAutoConfiguration {
    @Bean
    public ServiceRegistry serviceRegistry() {
        return new ServiceRegistry();
    }

    @Bean
    public ServiceProvider serviceProvider() {
        return new ServiceProvider();
    }

    @Bean
    public RPCServerHandler rpcServerHandler() {
        return new RPCServerHandler();
    }

    @Bean
    public ServerChannelInitializer serverChannelInitializer() {
        return new ServerChannelInitializer();
    }

    @Bean
    public RandomPortServiceStarter serviceStarter() {
        return new RandomPortServiceStarter();
    }
}
