package com.wf.ssm.ws.impl;

import javax.jws.WebService;

import com.wf.ssm.ws.VehicleRegService;

/**
 * 车辆远程注册接口，MES系统调用
 * @author wangpf
 */
@WebService(endpointInterface="com.wf.ssm.ws.VehicleRegService") 
public class VehicleRegServiceImpl implements VehicleRegService {
    /**
     * 增加车辆相关信息
     * @param vehicleBaseInfo
     * @param batteryInfo
     * @param vehicleModelInfo
     * @return
     */
    @Override
    public String add(String vehicleBaseInfo, String batteryInfo, String vehicleModelInfo) {
        return "add name";
    }

    /**
     * 根据VIN删除对应车辆的相关信息
     * @param vin
     * @return
     */
    @Override
    public String delete(String vin) {
        return "delete name";
    }

}
