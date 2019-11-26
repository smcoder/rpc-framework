package org.vision.rpc.registry;

/**
 * @author zhiyong.lt
 * */
public class ServiceCommon {
    public static String serviceBasePath = "service";

    public static String getServicePath(String serviceName) {
        return "/service/" + serviceName;
    }
}
