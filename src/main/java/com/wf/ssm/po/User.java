package com.wf.ssm.po;

import java.util.Date;
import java.util.List;

import com.wf.ssm.common.persistence.DataEntity;

public class User extends DataEntity<User> {
    
	private static final long serialVersionUID = -7408185747211659066L;

    private String username;

    private Date birthday;

    private String sex;

    private String address;
    
    //用户创建的订单列表
  	private List<Orders> ordersList;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
    
    public List<Orders> getOrdersList() {
		return ordersList;
	}
    
	public void setOrdersList(List<Orders> ordersList) {
		this.ordersList = ordersList;
	}
}