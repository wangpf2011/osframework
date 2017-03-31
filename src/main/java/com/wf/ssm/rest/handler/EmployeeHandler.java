package com.wf.ssm.rest.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.ssm.rest.dao.EmployeeDao;

@Controller
public class EmployeeHandler {
	
	@Autowired
	private EmployeeDao employeeDao;

	@RequestMapping("/emps")
	public String list(Model model) {
		model.addAttribute("employees", employeeDao.getEmployees());
		return "rest/employeeList";
	}
}
