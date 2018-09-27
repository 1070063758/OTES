package com.ssm.dao;

import java.util.List;

import com.ssm.pojo.User;
import com.ssm.pojo.function;

public interface UserMapper {
	User loginByUandP(User use);
	
	List<function> getFuncByStudent(User use);
	
	List<function> getFuncByTeacher(User use);
	
	List<function> getFuncByLeader(User use);
	
	List<function> getFuncByAdmin(User use);
	
	
	
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}