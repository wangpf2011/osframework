package com.wf.ssm.po;

import java.util.Date;
import java.util.List;

import com.wf.ssm.common.persistence.DataEntity;

public class User extends DataEntity<User> {
	private static final long serialVersionUID = -7408185747211659066L;

    private String username;
    
    private String sex;
    
    private Integer age;

    private Date birthday;
    
    private String mobile;
    
    private String address;
    
    //用户创建的订单列表
  	private List<Orders> ordersList;

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Orders> getOrdersList() {
		return ordersList;
	}
    
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
}