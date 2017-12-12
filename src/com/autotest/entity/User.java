package com.autotest.entity;

import java.io.Serializable;

/**
 * 用户实体类
 * @author emanon
 *
 */
public class User implements Serializable {
	private int id;
	private String loginName;
	private String loginPassword;
	
	public User() {}
	
	public User(int id) {
		super();
		this.id = id;
	}

	public User(String loginName, String loginPassword) {
		super();
		this.loginName = loginName;
		this.loginPassword = loginPassword;
	}
	
	public User(int id, String loginName, String loginPassword) {
		super();
		this.id = id;
		this.loginName = loginName;
		this.loginPassword = loginPassword;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public String getLoginName() {
		return loginName;
	}
	
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	
	public String getLoginPassword() {
		return loginPassword;
	}
	
	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}
}
