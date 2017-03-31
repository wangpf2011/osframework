package com.wf.ssm.rest.entity;

import com.wf.ssm.common.persistence.DataEntity;

/**
 * <P>人员实体</P>
 * 
 * @version 1.0
 * @author wangpf
 * @date 2017年3月31日 下午3:17:52
 */
public class Employee extends DataEntity<Employee> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7870436381316043972L;

	private Department departId;
	
	private String lastName;
	
	private String email;
	
	private String gender;
	
	public Employee() {
		super();
	}
	
	public Employee(String id, String lastName, String email, String gender, Department depart) {
		super(id);
		this.lastName = lastName;
		this.email = email;
		this.gender = gender;
		this.departId = depart;
	}
	
	public Department getDepartId() {
		return departId;
	}
	
	public void setDepartId(Department departId) {
		this.departId = departId;
	}
	
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
}
