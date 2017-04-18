package com.wf.ssm.netty.handler;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONObject;

/**
 * 对应Text消息的处理类
 * @author wangpf
 */
public class TextWebSocketFrameHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {
    
    private static final Logger logger = LoggerFactory.getLogger(TextWebSocketFrameHandler.class);
    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
    //private MonitorService monitorService = SpringContextHolder.getBean(MonitorService.class);

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame frame)
            throws Exception {
        Channel ch = ctx.channel();
        JSONObject json = JSONObject.parseObject(frame.text());
        // output current message to context.
        StringBuffer sb = new StringBuffer();
        sb.append(ch.remoteAddress())
        .append("->")
        .append(frame.text());
        logger.info(sb.toString());
        if("10001".equals(json.getString("code"))) {//车辆监控
            /*String data = monitorService.vehicleStatus(json.getString("msg"));
            ch.writeAndFlush(new TextWebSocketFrame(data));*/
        	ch.writeAndFlush(new TextWebSocketFrame(frame.text()));
        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        /*for (Channel channel : channels) {
            channel.writeAndFlush(new TextWebSocketFrame("[SERVER] - "
                    + incoming.remoteAddress() + " 加入"));
        }*/
        logger.info("Client:" + incoming.remoteAddress() + "加入");
        channels.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        /*for (Channel channel : channels) {
            channel.writeAndFlush(new TextWebSocketFrame("[SERVER] - "
                    + incoming.remoteAddress() + " 离开"));
        }*/
        logger.info("Client:" + incoming.remoteAddress() + "离开");
        channels.remove(ctx.channel());
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        logger.info("Client:" + incoming.remoteAddress() + "在线");
    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        logger.info("Client:" + incoming.remoteAddress() + "掉线");
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        logger.error("connection error and close the channel", cause);
        // 当出现异常就关闭连接
        cause.printStackTrace();
        ctx.close();
    }
}
