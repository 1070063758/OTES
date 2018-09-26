package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.dao.UserMapper;
import com.ssm.pojo.Student;
import com.ssm.pojo.User;
import com.ssm.pojo.function;
import com.ssm.service.IUserService;

@Service("userService")
public class UserService implements IUserService {

    @Resource
    private UserMapper userDao;

    public User getUserById(int userId) {
        return this.userDao.selectByPrimaryKey(userId);
    }

	@Override
	public User loginByUandP(String username, String password) {
		// TODO Auto-generated method stub
		User use = new User();
		use.setUserName(username);
		use.setPassword(password);
		User use1 = this.userDao.loginByUandP(use);
		return use1;
	}


	@Override
	public List<function> getFuncByuser(User use) {
		// TODO Auto-generated method stub
		String jobNumber = use.getJobNumber();
		int type = use.getType();
		if(type == 0){
			
			return this.userDao.getFuncByStudent(use);
		}
		if(type == 1){
			return this.userDao.getFuncByTeacher(use);
		}
		if(type == 2){
			return this.userDao.getFuncByLeader(use);
		}
		if(type == 3){
			return this.userDao.getFuncByAdmin(use);
		}
		return null;
	}

}