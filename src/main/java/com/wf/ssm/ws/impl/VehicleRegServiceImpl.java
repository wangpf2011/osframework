package com.wf.ssm.ws.impl;

import javax.jws.WebService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wf.ssm.ws.VehicleRegService;
import com.wf.ssm.ws.entity.BatteryInfo;
import com.wf.ssm.ws.entity.ReturnInfo;
import com.wf.ssm.ws.entity.VehicleBaseInfo;
import com.wf.ssm.ws.entity.VehicleModelInfo;
import com.wf.ssm.ws.interceptor.WSUtils;

/**
 * 车辆远程注册接口，MES系统调用
 * @author wangpf
 */
@WebService(endpointInterface = "com.lnint.jess.modules.ws.VehicleRegService")
public class VehicleRegServiceImpl implements VehicleRegService {
    /**
     * 日志对象
     */
    protected Logger logger = LoggerFactory.getLogger(getClass());
    
    /**
     * 增加车辆相关信息
     * @param vbi
     * @param bi
     * @param vmi
     * @return ReturnInfo
     */
    public ReturnInfo Add(VehicleBaseInfo vbi, BatteryInfo bi, VehicleModelInfo vmi) {
        ReturnInfo result = new ReturnInfo();
        result.setErrcode("0");
        //用户名、密码校验失败返回
        if(WSUtils.errorType == 1) {
            logger.info("VehicleRegServiceImpl.Add()  AUTH:FAIL");
            result.setErrcode("80000");
            result.setErrmsg("auth is failed");
            return result;
        }
        System.out.println(vbi.getVIN()+"--"+bi.getVIN()+"--"+vmi.getVIN());
        return result;
    }
    
    /**
     * 根据VIN删除对应车辆的相关信息
     * @param String VIN
     * @return ReturnInfo
     */
    public ReturnInfo Delete(String VIN) {
        ReturnInfo result = new ReturnInfo();
        result.setErrcode("0");
        //用户名、密码校验失败返回
        if(WSUtils.errorType == 1) {
            logger.info("VehicleRegServiceImpl.Delete()  AUTH:FAIL");
            result.setErrcode("80000");
            result.setErrmsg("auth is failed");
            return result;
        }
        
        System.out.println(VIN);
        return result;
    }
}
