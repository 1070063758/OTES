package com.ssm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.User;
import com.ssm.pojo.function;
import com.ssm.service.IUserService;

@Controller
@RequestMapping("/user")
public class UserController {

	@Resource
	private IUserService userService;
	
	
	@RequestMapping("/show")
	public String show(HttpServletRequest request, Model model) {
		
		return "redirect:/student/getTeacher";
	}
	
	

	@RequestMapping("/showUser")
	public String toIndex(HttpServletRequest request, Model model) {
		
		return "te";
	}
	
	
	@RequestMapping("/loginController")
	public String Index(HttpServletRequest request, String username,String password,Model model) {
		User use = this.userService.loginByUandP(username, password);
		model.addAttribute("user", use);
		switch (use.getType()) {
		case 0:
			model.addAttribute("type", "学生");
			break;
		case 1:
			model.addAttribute("type", "教师");
			break;
		case 2:
			model.addAttribute("type", "领导");
			break;
		case 3:
			model.addAttribute("type", "管理员");
			break;

		default:
			break;
		}
		String name = null;
		if(use != null){
			List<function> li = this.userService.getFuncByuser(use);
			model.addAttribute("func",li);
			for (function function : li) {
				name = function.getName();
				System.out.println(function.getFunc());
			}
			request.getSession().setAttribute("jobNumber", use.getJobNumber());
			request.getSession().setAttribute("name", name);
			return "main";
		}
		return "test";
	}
}