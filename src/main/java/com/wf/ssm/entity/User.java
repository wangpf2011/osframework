package com.wf.ssm.entity;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import com.wf.ssm.common.persistence.DataEntity;

public class User extends DataEntity<User> {
	private static final long serialVersionUID = -7408185747211659066L;
	
	@NotBlank(message="用户名不能为空")
    private String username;
	
	@NotBlank(message="密码不能为空")
	private String password;
    
	@NotBlank(message="性别不能为空")
    private String sex;
    
	@Max(value=100, message="年龄不能大于100")
	@Min(value=16, message="年龄不能小于16")
    private Integer age;

    @Past
    @NotNull
    private Date birthday;
    
    @Size(max=11,min=11,message="手机号长度为11位")
    private String mobile;
    
    @NotBlank(message="地址不能为空")
    private String address;
    
    //用户创建的订单列表
  	private List<Orders> ordersList;

    public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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