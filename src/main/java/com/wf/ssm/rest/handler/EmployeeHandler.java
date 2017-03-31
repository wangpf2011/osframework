package com.wf.ssm.rest.handler;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wf.ssm.rest.dao.DepartmentDao;
import com.wf.ssm.rest.dao.EmployeeDao;
import com.wf.ssm.rest.entity.Employee;

@Controller
public class EmployeeHandler {
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@ModelAttribute
	public void getEmployee(@RequestParam(value="id",required=false) String id, Model model) {
		if(StringUtils.isNotBlank(id)) {
			model.addAttribute("employee", employeeDao.getEmployee(id));
		}
	}
	
	@RequestMapping(value="emp", method=RequestMethod.PUT)
	public String update(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="emp/{id}", method=RequestMethod.GET)
	public String input(@PathVariable("id") String id, Model model) {
		model.addAttribute("departments", departmentDao.getDepartments());
		model.addAttribute("employee", employeeDao.getEmployee(id));
		return "rest/employeeInput";
	}
	
	@RequestMapping(value="emp", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") String id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="emp", method=RequestMethod.POST)
	public String save(Employee employee) {
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@RequestMapping(value="emp", method=RequestMethod.GET)
	public String input(Model model) {
		model.addAttribute("departments", departmentDao.getDepartments());
		model.addAttribute("employee", new Employee());
		return "rest/employeeInput";
	}

	@RequestMapping("/emps")
	public String list(Model model) {
		model.addAttribute("employees", employeeDao.getEmployees());
		return "rest/employeeList";
	}
}
