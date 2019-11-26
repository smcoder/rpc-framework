package org.vision.rpc.client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.LengthFieldPrepender;
import org.vision.rpc.pojo.RPCResponse;
import org.vision.rpc.pojo.RpcCall;

/**
 * @author zhiyong.lt
 * */
public class ClientChannelInitializer extends ChannelInitializer<SocketChannel> {

    public RPCClientHandlerImpl getRpcClientHandler() {
        return rpcClientHandler();
    }

    private RPCClientHandlerImpl rpcClientHandler = new RPCClientHandlerImpl();


    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        socketChannel.pipeline().addLast(new LengthFieldBasedFrameDecoder(65535, 0, 4, 0, 4))
                .addLast(new RPCDecoder<RPCResponse>() {})
                .addLast(new LengthFieldPrepender(4, false))
                .addLast(new RPCEncoder<RpcCall>() {})
                .addLast(rpcClientHandler);
    }
}
