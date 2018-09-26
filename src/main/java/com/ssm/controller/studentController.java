package com.ssm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.Student;
import com.ssm.service.IStudentService;

@Controller
@RequestMapping("/student")
public class studentController {

	@Resource
	private IStudentService studentService;

	@RequestMapping("/getTeacher")
	public String getTeacher(HttpServletRequest request, Model model) {
		String jobNumber = (String) request.getSession().getAttribute("jobNumber");
		System.out.println("jobNumber: "+jobNumber);
		List<Student> li = this.studentService.getTeacher(jobNumber);
		request.getSession().setAttribute("teacherList", li);
		for (Student student : li) {
			System.out.println(student.getName());
		}
		return "student/chooseTeacher";
	}
}