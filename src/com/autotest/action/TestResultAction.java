package com.autotest.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.autotest.biz.UserBiz;
import com.autotest.biz.UserBizImpl;
import com.autotest.entity.Test;
import com.autotest.util.HQLUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 查看测试结果Action
 * 
 * @author emanon
 *
 */
public class TestResultAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		List<Test> testResult = new ArrayList<Test>();
		Map<String, Object> loginInfo = ActionContext.getContext().getSession();
		String loginName = (String) loginInfo.get("loginName");
		String loginPassword = (String) loginInfo.get("loginPassword");
		UserBiz userBiz = new UserBizImpl();
		if (!userBiz.userLogin(loginName, loginPassword)) {
			return "error";
		}
		// 从测试数据库中找出当前用户提交的测试记录
		String hql = "";
		if (loginName.equals("vivo")) {
			hql = "from Test";
		} else {
			hql = "from Test where loginName = '" + loginName + "'";
		}
		testResult = HQLUtil.search(hql);
		ActionContext.getContext().put("testResult", testResult);
		System.out.println(testResult.size());
		return "result";
	}
}
