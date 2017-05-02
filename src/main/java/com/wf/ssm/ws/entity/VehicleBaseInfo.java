package com.wf.ssm.ws.entity;

/**
 * 车辆基础信息
 * @author wangpf
 */
public class VehicleBaseInfo {
    //车架号(车辆识别代号)
    private String VIN;
    //动力电池代码
    private String Arg1;
    //远程记录模块终端号
    private String Arg2;
    //发动机号
    private String Arg3;
    //车辆产品型号（对应整车公告车型）
    private String Arg4;
    
    public String getVIN() {
        return VIN;
    }
    
    public void setVIN(String vIN) {
        VIN = vIN;
    }
    
    public String getArg1() {
        return Arg1;
    }
    
    public void setArg1(String arg1) {
        Arg1 = arg1;
    }
    
    public String getArg2() {
        return Arg2;
    }
    
    public void setArg2(String arg2) {
        Arg2 = arg2;
    }
    
    public String getArg3() {
        return Arg3;
    }
    
    public void setArg3(String arg3) {
        Arg3 = arg3;
    }
    
    public String getArg4() {
        return Arg4;
    }
    
    public void setArg4(String arg4) {
        Arg4 = arg4;
    }
}
