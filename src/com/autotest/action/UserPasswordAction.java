package com.autotest.action;

import com.autotest.dao.UserDAO;
import com.autotest.dao.UserDAOImpl;
import com.autotest.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserPasswordAction extends ActionSupport {
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.get(id);
		ActionContext.getContext().put("loginName", user.getLoginName());
		ActionContext.getContext().put("loginPassword", user.getLoginPassword());
		ActionContext.getContext().getSession().put("id", id);
		return "success";
	}
	
}
