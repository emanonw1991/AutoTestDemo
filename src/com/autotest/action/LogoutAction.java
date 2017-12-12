package com.autotest.action;

import java.util.Map;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LogoutAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> loginInfo = ActionContext.getContext().getSession();
		loginInfo.put("loginName", null);
		loginInfo.put("loginPassword", null);
		loginInfo.put("isLogin", "no");
		loginInfo.put("user", null);
		return "success";
	}

}
