package com.wf.ssm.ws;

import javax.jws.WebService;

import com.wf.ssm.ws.entity.BatteryInfo;
import com.wf.ssm.ws.entity.ReturnInfo;
import com.wf.ssm.ws.entity.VehicleBaseInfo;
import com.wf.ssm.ws.entity.VehicleModelInfo;

/**
 * 车辆远程注册接口，MES系统调用
 * @author wangpf
 */
@WebService
public interface VehicleRegService {
	/**
     * 增加车辆相关信息
     * @param vbi
     * @param bi
     * @param vmi
     * @return ReturnInfo
     */
    public ReturnInfo Add(VehicleBaseInfo vbi, BatteryInfo bi, VehicleModelInfo vmi);
    
    /**
     * 根据VIN删除对应车辆的相关信息
     * @param String VIN
     * @return ReturnInfo
     */
    public ReturnInfo Delete(String VIN);
}
