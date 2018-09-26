package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.studentMapper;
import com.ssm.pojo.Student;
import com.ssm.pojo.User;
import com.ssm.service.IStudentService;

@Service("studentService")
public class StudentService implements IStudentService {
	
	@Resource
	private studentMapper student;

	@Override
	public List<Student> getTeacher(String jobNumber) {
		// TODO Auto-generated method stub
		return this.student.getTeacher(jobNumber);
	}

}
