package com.wf.ssm.po;

/**
 * <P>订单的扩展类</P>
 * 
 * @version 1.0
 * @author wangpf
 * @date 2017年3月23日 下午3:33:32
 */
//通过此类映射订单和用户查询的结果，让此类继承包括 字段较多的pojo类
public class OrdersCustom extends Orders{
	private static final long serialVersionUID = -3513806461758356460L;
	
	//添加用户属性
	/*USER.username,
	  USER.sex,
	  USER.address */
	private String username;
	
	private String sex;
	
	private String address;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
