package com.ssm.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.updateMapper;
import com.ssm.pojo.Student;

@Service("update")
public class updateService implements com.ssm.service.IUpdateService {
	

	@Resource
	private updateMapper updateMap;
	@Override
	public boolean updateStudent(String name, String studentNumber, String classID) {
		// TODO Auto-generated method stub
		int result = this.updateMap.updateStudent(name,studentNumber,classID);
		if(result > 0){
			return true;
		}else {
			return false;
		}
	}
	@Override
	public boolean updateTeacher(String name, String teacherid, String departid, String courseID) {
		// TODO Auto-generated method stub
		int result = this.updateMap.updateTeacher(name, teacherid, departid, courseID);
		if(result > 0){
			return true;
		}
		return false;
	}

}
