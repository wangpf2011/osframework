package com.wf.ssm.netty.handler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;
import io.netty.handler.codec.http.websocketx.WebSocketServerHandshakerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wf.ssm.netty.util.Constants;

/**
 * HTTP请求处理类
 * @author wangpf
 */
public class HttpRequestHandler extends SimpleChannelInboundHandler<FullHttpRequest> {
    private static final Logger logger = LoggerFactory.getLogger(HttpRequestHandler.class);

    private WebSocketServerHandshaker handshaker;
    
    private final String wsUri;
    public HttpRequestHandler(String wsUri) {
        this.wsUri = wsUri;
    }

    @SuppressWarnings("deprecation")
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        if(wsUri.equalsIgnoreCase(request.getUri())) {
            //后续消息交给TextWebSocketFrameHandler处理
            ctx.fireChannelRead(request.retain());
        }else {
            handleHttpRequest(ctx, request);
        }
    }

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        /*if (evt instanceof IdleStateEvent) {
            IdleStateEvent evnet = (IdleStateEvent) evt;
            // 判断Channel是否读空闲, 读空闲时移除Channel
            if (evnet.state().equals(IdleState.READER_IDLE)) {
                final String remoteAddress = NettyUtil.parseChannelRemoteAddr(ctx.channel());
                logger.warn("NETTY SERVER PIPELINE: IDLE exception [{}]", remoteAddress);
            }
        }*/
        ctx.fireUserEventTriggered(evt);
    }

    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request) {
        if (!request.decoderResult().isSuccess() || !"websocket".equals(request.headers().get("Upgrade"))) {
            logger.warn("protobuf don't support websocket");
            ctx.channel().close();
            return;
        }
        // Websocket 握手开始  
        WebSocketServerHandshakerFactory handshakerFactory = new WebSocketServerHandshakerFactory(
                Constants.WEBSOCKET_URL, null, true);
        handshaker = handshakerFactory.newHandshaker(request);
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedVersionResponse(ctx.channel());
        } else {
            handshaker.handshake(ctx.channel(), request);
        }
    }
}
