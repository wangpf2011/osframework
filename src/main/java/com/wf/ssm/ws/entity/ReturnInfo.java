package com.wf.ssm.ws.entity;

/**
 * -1  系统繁忙，稍后再试
 *  0   请求成功
 *  40001   不合法的参数
 *  40002   车辆已经存在
 *  40003   产品型号不存在
 *  40004   产品型号已存在
 *  80000   系统错误(system error)
 *  
 * @author wangpf
 *
 */
public class ReturnInfo {
    private String Errcode;
    private String Errmsg;
    
    public String getErrcode() {
        return Errcode;
    }
    public void setErrcode(String errcode) {
        Errcode = errcode;
    }
    public String getErrmsg() {
        return Errmsg;
    }
    public void setErrmsg(String errmsg) {
        Errmsg = errmsg;
    }
}
