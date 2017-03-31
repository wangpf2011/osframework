package com.wf.ssm.rest.dao;

import java.util.Collection;
import java.util.Map;

import com.google.common.collect.Maps;
import com.wf.ssm.rest.entity.Department;

public class DepartmentDao {
	private static Map<String, Department> departments = null; 
	
	static {
		departments = Maps.newHashMap();
		departments.put("101", new Department("101", "D-AA"));
		departments.put("102", new Department("102", "D-BB"));
		departments.put("103", new Department("103", "D-CC"));
		departments.put("104", new Department("104", "D-DD"));
		departments.put("105", new Department("105", "D-EE"));
	}
	
	/**
	 * 列表数据
	 * @return
	 * @author wangpf
	 * @date 2017年3月31日 下午3:50:00
	 */
	public Collection<Department> getDepartments() {
		return departments.values();
	}
	
	/**
	 * 根据id查询
	 * @param id
	 * @return
	 * @author wangpf
	 * @date 2017年3月31日 下午3:50:13
	 */
	public Department getDepartment(String id) {
		return departments.get(id);
	}
}
