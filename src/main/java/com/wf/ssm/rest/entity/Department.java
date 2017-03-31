package com.wf.ssm.rest.entity;

import com.wf.ssm.common.persistence.DataEntity;

public class Department extends DataEntity<Department> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String depatName;
	
	public Department(String id, String name) {
		super(id);
		this.depatName = name;
	}

	public String getDepatName() {
		return depatName;
	}

	public void setDepatName(String depatName) {
		this.depatName = depatName;
	}
}
