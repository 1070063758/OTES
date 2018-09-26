package com.ssm.pojo;

public class User {
    private Integer id;

    private String userName;

    private String password;
    
    private String jobNumber;
    
    private int type;
    
    
    
    

    public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getJobNumber() {
		return jobNumber;
	}

	public void setJobNumber(String jobNumber) {
		this.jobNumber = jobNumber;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    

    public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }
}