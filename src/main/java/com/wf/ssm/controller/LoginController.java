package com.wf.ssm.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.ssm.po.User;

@Controller
public class LoginController {

	// 登陆
	@RequestMapping("/login")
	public String login(HttpSession session, String username, String password)
			throws Exception {
		// 调用service进行用户身份验证
		
		// 在session中保存用户身份信息
		session.setAttribute("username", username);
		// 重定向到商品列表页面
		return "redirect:/products/queryProducts.action";
	}

	// 退出
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		// 清除session
		session.invalidate();

		// 重定向到商品列表页面
		return "redirect:/login.action";
	}
	
	// 退出
	@RequestMapping("/register")
	public String register(HttpServletRequest request, 
			HttpServletResponse response, 
			@Validated User user, 
			BindingResult bindingResult) throws Exception {
		return "";
	}
}
