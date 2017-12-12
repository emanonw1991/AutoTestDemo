package com.autotest.interceptor;

import java.util.Map;

import com.autotest.biz.UserBiz;
import com.autotest.biz.UserBizImpl;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * Action访问权限控制拦截器
 * @author emanon
 *
 */
public class LoginInterceptor extends AbstractInterceptor {
	
	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("interceptor start");
		Map<String, Object> session = arg0.getInvocationContext().getSession();
		String isLogin = (String) session.get("isLogin");
		String loginName = (String) session.get("loginName");
		String loginPassword = (String) session.get("loginPassword");
		UserBiz userBiz = new UserBizImpl();
		boolean flag = userBiz.userLogin(loginName, loginPassword);
		if (isLogin == null || isLogin.equals("no") || !flag) {
			return "login";
		} else {
			return arg0.invoke();
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		super.init();
		ActionContext.getContext().getSession().put("directLogin", true);
	}

}
