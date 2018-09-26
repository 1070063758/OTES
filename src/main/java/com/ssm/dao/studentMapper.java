package com.ssm.dao;

import java.util.List;

import com.ssm.pojo.Student;
import com.ssm.pojo.User;

public interface studentMapper {
	
	List<Student> getTeacher(String jobNumber);

}
