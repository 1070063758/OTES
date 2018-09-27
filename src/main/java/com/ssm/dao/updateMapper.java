package com.ssm.dao;

import org.apache.ibatis.annotations.Param;

public interface updateMapper {
	
	int updateStudent(@Param("name") String name,@Param("studentNumber") String studentNumber,@Param("classID") String classID);

	int updateTeacher(@Param("name") String name,@Param("teacherid") String teacherid,@Param("departid") String departid,@Param("courseID") String courseID);
}
