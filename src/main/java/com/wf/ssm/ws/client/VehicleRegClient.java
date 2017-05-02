package com.wf.ssm.ws.client;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

import com.wf.ssm.ws.VehicleRegService;

public class VehicleRegClient {
    public static void main(String[] args) {
        //创建WebService客户端代理工厂
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
        //注册WebService接口
        factory.setServiceClass(VehicleRegService.class);
        //设置WebService地址
        factory.setAddress("http://localhost:8080/osframework/services/vehicleService");
        VehicleRegService vehicleRegService = (VehicleRegService)factory.create();
        System.out.println("invoke webservice...");
        System.out.println("message context is:"+vehicleRegService.Add(null, null, null)); 
    }
}
