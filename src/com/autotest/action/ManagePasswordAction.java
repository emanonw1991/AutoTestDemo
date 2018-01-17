package com.autotest.action;

import com.autotest.dao.UserDAO;
import com.autotest.dao.UserDAOImpl;
import com.autotest.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ManagePasswordAction extends ActionSupport {
	private String newPassword;
	private String confirmPassword;
	
	public String getNewPassword() {
		return newPassword;
	}
	
	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}
	
	public String getConfirmPassword() {
		return confirmPassword;
	}
	
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		int id = (Integer) ActionContext.getContext().getSession().get("id");
		UserDAO userDAO = new UserDAOImpl();
		User user = userDAO.get(id);
		user.setLoginPassword(newPassword);
		userDAO.update(user);
		User u = (User) ActionContext.getContext().getSession().get("user");
		int id_u = u.getId();
		if (id == id_u) {
			return "success";
		} else {
			return "step";
		}
	}
}
