package org.vision.rpc.client;

import com.google.common.util.concurrent.SettableFuture;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import org.springframework.util.Assert;
import org.vision.rpc.pojo.RPCResponse;
import org.vision.rpc.pojo.RpcCall;

import java.net.SocketAddress;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author zhiyong.lt
 * */
public class RPCClientHandlerImpl extends SimpleChannelInboundHandler<RPCResponse> implements RPCClientHandler {

    private Channel channel;
    private SocketAddress serverAddress;
    private ConcurrentHashMap<String, SettableFuture<RPCResponse>> responseContext = new ConcurrentHashMap<>(16);

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, RPCResponse rpcResponse) throws Exception {
        String requestId = rpcResponse.getRequestId();
        SettableFuture<RPCResponse> rpcResponseSettableFuture = responseContext.get(requestId);
        Assert.notNull(rpcResponseSettableFuture, "rpcResponseFuture for requestId " + requestId + " should not be null");
        responseContext.remove(requestId);
        rpcResponseSettableFuture.set(rpcResponse);
    }

    @Override
    public SettableFuture<RPCResponse> sendRequest(RpcCall rpcCall) {
        String requestId = rpcCall.getId();
        SettableFuture<RPCResponse> future = SettableFuture.create();
        responseContext.put(requestId, future);
        Assert.notNull(requestId, "requestId not null");
        channel.writeAndFlush(rpcCall);
        return future;
    }

    public SocketAddress getServerAddress() {
        return serverAddress;
    }

    @Override
    public void channelRegistered(ChannelHandlerContext ctx) throws Exception {
        super.channelRegistered(ctx);
        channel = ctx.channel();
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        super.channelActive(ctx);
        serverAddress = ctx.channel().remoteAddress();
    }
}
