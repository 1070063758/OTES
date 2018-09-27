package com.ssm.dao;

import java.util.List;

import com.ssm.pojo.Student;

public interface studentMapper {
	
	List<Student> getTeacher(String jobNumber);

}
