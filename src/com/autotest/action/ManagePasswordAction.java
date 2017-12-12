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

	@Override
	public void validate() {
		// TODO Auto-generated method stub
		if (getNewPassword() != null && getConfirmPassword() != null) {
			if (!getNewPassword().equals(getConfirmPassword())) {
				this.addFieldError("msg", "密码不一致！");
			} else {
				User user = (User) ActionContext.getContext().getSession().get("user");
				String loginPassword = user.getLoginPassword();
				if (getNewPassword().equals(loginPassword)) {
					this.addFieldError("msg", "密码与原密码相同！");
				}
			}
		}
		super.validate();
	}
	
}
