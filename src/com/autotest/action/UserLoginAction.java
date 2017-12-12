package com.autotest.action;

import java.util.Map;

import com.autotest.biz.UserBiz;
import com.autotest.biz.UserBizImpl;
import com.autotest.dao.UserDAO;
import com.autotest.dao.UserDAOImpl;
import com.autotest.entity.User;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * ÓÃ»§µÇÂ½Action
 * @author emanon
 *
 */
public class UserLoginAction extends ActionSupport {
	private String loginName;
	private String loginPassword;
	
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
	
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		UserBiz userBiz = new UserBizImpl();
		boolean flag = userBiz.userLogin(loginName, loginPassword);
		Map<String,Object> loginInfo = ActionContext.getContext().getSession();
		loginInfo.put("loginName", loginName);
		loginInfo.put("loginPassword", loginPassword);
		if (flag) {
			int id = userBiz.getId(loginName, loginPassword);
			UserDAO userDAO = new UserDAOImpl();
			User user = userDAO.get(id);
			loginInfo.put("user", user);
			loginInfo.put("isLogin", "yes");
			return "success";
		} else {
			ActionContext.getContext().put("loginSuccess", "no");
			return "error";
		}
	}
}
