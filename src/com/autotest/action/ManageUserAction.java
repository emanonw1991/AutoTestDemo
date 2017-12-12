package com.autotest.action;

import java.util.List;

import com.autotest.entity.User;
import com.autotest.util.HQLUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class ManageUserAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String hql = "from User";
		List<User> userList = HQLUtil.search(hql);
		ActionContext.getContext().put("userList", userList);
		return "success";
	}

}
