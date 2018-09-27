package com.ssm.service;

public interface IUpdateService {

	public boolean updateStudent(String name, String studentNumber, String classID);
	
	public boolean updateTeacher(String name, String teacherid, String departid ,String courseID);
}
