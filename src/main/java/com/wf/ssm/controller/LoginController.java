package com.wf.ssm.controller;

import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.wf.ssm.common.utils.IdGen;
import com.wf.ssm.po.User;
import com.wf.ssm.service.UserService;

@Controller
public class LoginController {
	@Autowired
	private UserService userService;

	//登陆页面
	@RequestMapping("/login")
	public String login()
			throws Exception {
		return "login";
	}
	
	//执行登陆操作
	@RequestMapping("/doLogin")
	public String doLogin(HttpSession session, String username, String password)
			throws Exception {
		// 调用service进行用户身份验证
		
		// 在session中保存用户身份信息
		session.setAttribute("username", username);
		// 重定向到商品列表页面
		return "redirect:/products/queryProducts.action";
	}

	//执行退出操作
	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		// 清除session
		session.invalidate();

		// 重定向到商品列表页面
		return "redirect:/login.action";
	}
	
	//注册页面
	@RequestMapping("/register")
	public String register() throws Exception {
		return "register";
	}
	
	// 退出
	@RequestMapping("/doRegister")
	public String doRegister(HttpServletRequest request, 
			HttpServletResponse response, 
			Model model,
			@ModelAttribute("user") @Validated User user, 
			BindingResult bindingResult) throws Exception {
		// 获取校验错误信息
		if(bindingResult.hasErrors()) {
			// 输出错误信息
			/*List<ObjectError> allErrors = bindingResult.getAllErrors();
			for(ObjectError objectError : allErrors) {
				// 输出错误信息
				model.addAttribute("msg_"+objectError.getObjectName(), objectError.getDefaultMessage());
			}
			return "redirect:/register.action";*/
			List<FieldError> errors = bindingResult.getFieldErrors();
			for(FieldError fieldError : errors) {
				model.addAttribute("msg_"+fieldError.getField(), fieldError.getDefaultMessage());
				return "forward:/register.action";
			}
		}
		user.setId(IdGen.uuid());
		//注册信息入库
		userService.insert(user);
		return "redirect:/login.action";
	}
}
