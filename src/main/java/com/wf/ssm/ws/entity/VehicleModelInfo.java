package com.wf.ssm.ws.entity;

/**
 * 车辆产品型号信息类
 * @author wangpf
 */
public class VehicleModelInfo {
    //车架号(车辆识别代号)
    private String VIN;
    //车辆产品型号名称（对应整车公告车型）
    private String Name;
    //车辆类型(1、纯电动汽车，2、插电式混合动力汽车，3、燃料电池汽车)
    private String Type;
    //储能装置种类(01H铅酸电池，02H镍氢电池，03H磷酸铁锂电池，04H锰酸锂电池，05H钴酸锂电池，06H三元材料电池，
    //07H聚合物锂电子电池，08H超级电容，09H钛酸锂电池、FF其他电池
    private String Arg1;
    //驱动电机类型(1、直流电机，2：异步电机，3：同步电机，4、开关磁阻)
    private String Arg2;
    //驱动电机额定功率
    private String Arg3;
    //驱动电机额定转速
    private String Arg4;
    //驱动电机额定转矩
    private String Arg5;
    //驱动电机安装数量
    private Integer Arg6;
    //驱动电机布置形式/位置(1、前置横式，2、前置纵式，3、后置横式，4、后置纵式，5、中置横式，6、中置纵式)
    private String Arg7;
    //驱动电机冷却方式(1、液冷，2、风冷)
    private String Arg8;
    //电动汽车续航里程
    private String Arg9;
    //电动汽车最高车速
    private String Arg10;
    //电池组额定能量
    private String Arg11;
    //电池组额定电压
    private String Arg12;
    //车辆产品型号(EK05/EK05A/EV25A/EC35)
    private String Arg13;
    //配置编码
    private String Arg14;
    //颜色
    private String Arg15;
    //额定载客
    private Integer Arg16;
    //车身号
    private String Arg17;
    //单价
    private String Arg18;
    //金额
    private String Arg19;
    //标定识别号
    private String Arg20;
    //标定校验号（CVN）
    private String Arg21;
    
    public String getVIN() {
        return VIN;
    }
    public void setVIN(String vIN) {
        VIN = vIN;
    }
    public String getName() {
        return Name;
    }
    public void setName(String name) {
        Name = name;
    }
    public String getType() {
        return Type;
    }
    public void setType(String type) {
        Type = type;
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
    public String getArg5() {
        return Arg5;
    }
    public void setArg5(String arg5) {
        Arg5 = arg5;
    }
    public Integer getArg6() {
        return Arg6;
    }
    public void setArg6(Integer arg6) {
        Arg6 = arg6;
    }
    public String getArg7() {
        return Arg7;
    }
    public void setArg7(String arg7) {
        Arg7 = arg7;
    }
    public String getArg8() {
        return Arg8;
    }
    public void setArg8(String arg8) {
        Arg8 = arg8;
    }
    public String getArg9() {
        return Arg9;
    }
    public void setArg9(String arg9) {
        Arg9 = arg9;
    }
    public String getArg10() {
        return Arg10;
    }
    public void setArg10(String arg10) {
        Arg10 = arg10;
    }
    public String getArg11() {
        return Arg11;
    }
    public void setArg11(String arg11) {
        Arg11 = arg11;
    }
    public String getArg12() {
        return Arg12;
    }
    public void setArg12(String arg12) {
        Arg12 = arg12;
    }
    public String getArg13() {
        return Arg13;
    }
    public void setArg13(String arg13) {
        Arg13 = arg13;
    }
    public String getArg14() {
        return Arg14;
    }
    public void setArg14(String arg14) {
        Arg14 = arg14;
    }
    public String getArg15() {
        return Arg15;
    }
    public void setArg15(String arg15) {
        Arg15 = arg15;
    }
    public Integer getArg16() {
        return Arg16;
    }
    public void setArg16(Integer arg16) {
        Arg16 = arg16;
    }
    public String getArg17() {
        return Arg17;
    }
    public void setArg17(String arg17) {
        Arg17 = arg17;
    }
    public String getArg18() {
        return Arg18;
    }
    public void setArg18(String arg18) {
        Arg18 = arg18;
    }
    public String getArg19() {
        return Arg19;
    }
    public void setArg19(String arg19) {
        Arg19 = arg19;
    }
    public String getArg20() {
        return Arg20;
    }
    public void setArg20(String arg20) {
        Arg20 = arg20;
    }
    public String getArg21() {
        return Arg21;
    }
    public void setArg21(String arg21) {
        Arg21 = arg21;
    }
}
