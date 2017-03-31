package com.wf.ssm.rest.dao;

import java.util.Collection;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.google.common.collect.Maps;
import com.wf.ssm.common.utils.IdGen;
import com.wf.ssm.rest.entity.Department;
import com.wf.ssm.rest.entity.Employee;

@Repository
public class EmployeeDao {
	private static Map<String, Employee> employees = null; 
	
	static {
		employees = Maps.newHashMap();
		employees.put("1001", new Employee("1001", "E-AA", "aa@163.com", "1", new Department("101", "D-AA")));
		employees.put("1002", new Employee("1002", "E-BB", "bb@163.com", "1", new Department("102", "D-BB")));
		employees.put("1003", new Employee("1003", "E-CC", "cc@163.com", "1", new Department("103", "D-CC")));
		employees.put("1004", new Employee("1004", "E-DD", "dd@163.com", "1", new Department("104", "D-DD")));
		employees.put("1005", new Employee("1005", "E-EE", "ee@163.com", "1", new Department("105", "D-EE")));
	}
	
	/**
	 * 数据列表
	 * @return
	 * @author wangpf
	 * @date 2017年3月31日 下午4:06:12
	 */
	public Collection<Employee> getEmployees() {
		return employees.values();
	}
	
	/**
	 * 根据id获取实体
	 * @param id
	 * @return
	 * @author wangpf
	 * @date 2017年3月31日 下午4:05:56
	 */
	public Employee getEmployee(String id) {
		return employees.get(id);
	}
	
	/**
	 * 添加
	 * @param employee
	 * @author wangpf
	 * @date 2017年3月31日 下午4:05:41
	 */
	public void save(Employee employee) {
		if(employee.getId() == null) {
			employee.setId(IdGen.uuid());
		}
		employees.put(employee.getId(), employee);
	}
	
	/**
	 * 删除
	 * @param id
	 * @author wangpf
	 * @date 2017年3月31日 下午4:05:32
	 */
	public void delete(String id) {
		employees.remove(id);
	}
}
