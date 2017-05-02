package com.wf.ssm.ws.entity;

/**
 * 动力电池信息
 * @author wangpf
 */
public class BatteryInfo {
    //车架号(车辆识别代号)
    private String VIN;
    //动力电池代码
    private String Arg1;
    //动力电池包总数
    private Integer Arg2;
    //左前电池包所装单体数量
    private Integer Arg3;
    //右前电池包所装单体数量
    private Integer Arg4;
    //后电池包所装单体数量
    private Integer Arg5;
    //左前电池包所装温度探针数量
    private Integer Arg6;
    //右前电池包所装温度探针数量
    private Integer Arg7;
    //后电电池包所装温度探针数量
    private Integer Arg8;
    
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
    public Integer getArg2() {
        return Arg2;
    }
    public void setArg2(Integer arg2) {
        Arg2 = arg2;
    }
    public Integer getArg3() {
        return Arg3;
    }
    public void setArg3(Integer arg3) {
        Arg3 = arg3;
    }
    public Integer getArg4() {
        return Arg4;
    }
    public void setArg4(Integer arg4) {
        Arg4 = arg4;
    }
    public Integer getArg5() {
        return Arg5;
    }
    public void setArg5(Integer arg5) {
        Arg5 = arg5;
    }
    public Integer getArg6() {
        return Arg6;
    }
    public void setArg6(Integer arg6) {
        Arg6 = arg6;
    }
    public Integer getArg7() {
        return Arg7;
    }
    public void setArg7(Integer arg7) {
        Arg7 = arg7;
    }
    public Integer getArg8() {
        return Arg8;
    }
    public void setArg8(Integer arg8) {
        Arg8 = arg8;
    }
}
