package org.vision.rpc.client;

import com.google.common.util.concurrent.SettableFuture;
import org.vision.rpc.pojo.RPCResponse;
import org.vision.rpc.pojo.RpcCall;

/**
 * @author zhiyong.lt
 * */
public interface RPCClientHandler {
    SettableFuture<RPCResponse> sendRequest(RpcCall rpcCall);
}
