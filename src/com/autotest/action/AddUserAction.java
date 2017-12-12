package com.autotest.action;

import com.autotest.biz.UserBiz;
import com.autotest.biz.UserBizImpl;
import com.autotest.dao.UserDAO;
import com.autotest.dao.UserDAOImpl;
import com.autotest.entity.User;
import com.opensymphony.xwork2.ActionSupport;

public class AddUserAction extends ActionSupport {
	private String userName;
	private String userPassword;
	
	public String getUserName() {
		return userName;
	}
	
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getUserPassword() {
		return userPassword;
	}
	
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		User user = new User(userName, userPassword);
		UserDAO userDAO = new UserDAOImpl();
		userDAO.add(user);
		return "success";
	}
	
}
