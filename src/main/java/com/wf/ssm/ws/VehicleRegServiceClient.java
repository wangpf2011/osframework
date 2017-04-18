package com.wf.ssm.ws;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;

/**
 * WebService客户端
 * @author wangpf
 */
public class VehicleRegServiceClient {
    public static void main(String[] args) {
        invokByJava();
    }
    public static void invokByJava(){  
        JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();  
        factory.setServiceClass(VehicleRegService.class);  
        factory.setAddress("http://localhost:8080/osframework/services/vehicleService");  
        VehicleRegService vehicleRegService = (VehicleRegService)factory.create();  
        System.out.println(vehicleRegService.add("info1", "info2", "info3"));  
    } 
}
