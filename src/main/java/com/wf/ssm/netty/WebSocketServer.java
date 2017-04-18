package com.wf.ssm.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import java.net.InetSocketAddress;

import com.wf.ssm.netty.core.BaseServer;
import com.wf.ssm.netty.handler.TextWebSocketFrameHandler;
import com.wf.ssm.netty.handler.HttpRequestHandler;

/**
 * WebSocketServer系统主类
 * @author wangpf
 */
public class WebSocketServer extends BaseServer {
    //定时执行任务
    //private ScheduledExecutorService executorService;

    public WebSocketServer(int port) {
        this.port = port;
        //executorService = Executors.newScheduledThreadPool(2);
    }

    @Override
    public void start() {
        try {
            b.group(bossGroup, workGroup)
            .channel(NioServerSocketChannel.class)
            .option(ChannelOption.SO_KEEPALIVE, true)
            .option(ChannelOption.TCP_NODELAY, true)
            .option(ChannelOption.SO_BACKLOG, 1024)
            .localAddress(new InetSocketAddress(port))
            .childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    /*ch.pipeline().addLast(defLoopGroup,
                            new HttpServerCodec(),   //请求解码器
                            new HttpObjectAggregator(65536),//将多个消息转换成单一的消息对象
                            new ChunkedWriteHandler(),  //支持异步发送大的码流，一般用于发送文件流
                            new IdleStateHandler(60, 0, 0), //检测链路是否读空闲
                            new HttpRequestHandler(), //处理握手和认证
                            new TextWebSocketFrameHandler()    //处理消息的发送
                    );*/
                    ch.pipeline().addLast(new HttpServerCodec());
                    ch.pipeline().addLast(new HttpObjectAggregator(64*1024));
                    ch.pipeline().addLast(new ChunkedWriteHandler());
                    ch.pipeline().addLast(new HttpRequestHandler());
                    //ch.pipeline().addLast(new WebSocketServerProtocolHandler("/ws"));
                    ch.pipeline().addLast(new TextWebSocketFrameHandler());
                }
            });
            // 绑定端口，开始接收进来的连接
            cf = b.bind().sync();
            InetSocketAddress addr = (InetSocketAddress) cf.channel().localAddress();
            logger.info("WebSocketServer start success, port is:{}", addr.getPort());

            /*// 定时扫描所有的Channel，关闭失效的Channel
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                    logger.info("scanNotActiveChannel --------");
                }
            }, 3, 60, TimeUnit.SECONDS);

            // 定时向所有客户端发送Ping消息
            executorService.scheduleAtFixedRate(new Runnable() {
                @Override
                public void run() {
                }
            }, 3, 50, TimeUnit.SECONDS);*/
            // 等待服务器 socket 关闭 。在这个例子中，这不会发生，但你可以优雅地关闭你的服务器。
            //cf.channel().closeFuture().sync();
        }catch (Exception e) {
            logger.error("WebSocketServer start fail,", e);
            e.printStackTrace();
        }
    }

    @Override
    public void shutdown() {
        super.shutdown();
    }
}
