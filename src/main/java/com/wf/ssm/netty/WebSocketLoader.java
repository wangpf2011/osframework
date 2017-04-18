package com.wf.ssm.netty;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.wf.ssm.netty.util.Constants;

/**
 * 运行WebSocket服务端
 * 
 * 暂时未用该监听器，改用初始化spring容器监听器
 *
 * @version 1.0
 * @author 王朋飞 2015-07-01
 * @since JDK 1.6
 */
public class WebSocketLoader implements ServletContextListener {
	//WebSocketServer  
    private WebSocketServer server;  
      
    @Override  
    public void contextDestroyed(ServletContextEvent contextEvent) {
        if(server != null) server.shutdown();
    }  
  
    @Override  
    public void contextInitialized(ServletContextEvent contextEvent) {
        if(null == server) {
            server = new WebSocketServer(Constants.DEFAULT_PORT);
            server.init();
            server.start();
        }  
    }
}
