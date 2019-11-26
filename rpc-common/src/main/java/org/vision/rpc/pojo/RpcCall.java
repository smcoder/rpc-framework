package org.vision.rpc.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author zhiyong.lt
 * */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RpcCall {
    private String id;
    private String className;
    private String methodName;
    private String[] parameterTypes;
    private Object[] parameters;

    public RpcCall copy() {
        RpcCall other = new RpcCall();
        this.id = other.id;
        this.className = other.className;
        this.methodName = other.methodName;
        this.parameterTypes = other.parameterTypes;
        this.parameters = other.parameters;
        return other;
    }

}
