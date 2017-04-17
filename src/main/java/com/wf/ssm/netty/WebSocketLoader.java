package com.wf.ssm.netty;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.wf.ssm.netty.util.Constants;
/**
 * 运行WebSocket服务端
 *
 * @version 1.0
 * @author 王朋飞 2015-07-01
 * @since JDK 1.6
 */
public class WebSocketLoader implements ServletContextListener {
	/**
	 * 日志对象
	 */
	protected Logger logger = LoggerFactory.getLogger(getClass());
	
	//WebSocketServer  
    private WebSocketServer server;  
      
    @Override  
    public void contextDestroyed(ServletContextEvent arg0) {
        if(server != null) server.shutdown();
    }  
  
    @Override  
    public void contextInitialized(ServletContextEvent arg0) {
        if(null == server) {
            server = new WebSocketServer(Constants.DEFAULT_PORT);
            server.init();
            server.start();
        }  
    }
}
