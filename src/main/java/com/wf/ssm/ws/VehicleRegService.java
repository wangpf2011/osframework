package com.wf.ssm.ws;

import javax.jws.WebService;

/**
 * 车辆远程注册接口，MES系统调用
 * @author wangpf
 */
@WebService
public interface VehicleRegService {
    /**
     * 增加车辆相关信息
     * @param vehicleBaseInfo
     * @param batteryInfo
     * @param vehicleModelInfo
     * @return
     */
    public String add(String vehicleBaseInfo, String batteryInfo, String vehicleModelInfo);
    
    /**
     * 根据VIN删除对应车辆的相关信息
     * @param vin
     * @return
     */
    public String delete(String vin);
}
