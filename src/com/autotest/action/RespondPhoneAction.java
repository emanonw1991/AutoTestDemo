package com.autotest.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;

/**
 * 响应手机请求Action
 * @author emanon
 *
 */
public class RespondPhoneAction extends ActionSupport {

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();
		String code = request.getParameter("code");
		switch (code) {
		case "start":
			break;
		case "result":
			break;
		default:
			break;
		}
		return NONE;
	}

}
