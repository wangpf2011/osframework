package com.lnint.ssm.po;

import java.util.Date;

import com.lnint.ssm.common.persistence.DataEntity;

public class Orders extends DataEntity<Orders> {
    
	private static final long serialVersionUID = -3358025824587676038L;

	private String userId;

    private String number;

    private Date createtime;

    private String note;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number == null ? null : number.trim();
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note == null ? null : note.trim();
    }
}