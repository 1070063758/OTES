package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Student;
import com.ssm.pojo.User;
import com.ssm.pojo.function;

public interface IUserService {

	public User getUserById(int userId);
	
	public User loginByUandP(String username,String password);
	
	public List<function> getFuncByuser(User use);

}