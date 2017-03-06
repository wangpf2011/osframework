package com.lnint.ssm.po;

import java.util.Date;

import com.lnint.ssm.common.persistence.DataEntity;

public class User extends DataEntity<User> {
    
	private static final long serialVersionUID = -7408185747211659066L;

    private String username;

    private Date birthday;

    private String sex;

    private String address;

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
}