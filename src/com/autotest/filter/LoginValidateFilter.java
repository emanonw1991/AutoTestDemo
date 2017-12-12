package com.autotest.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import com.opensymphony.xwork2.ActionContext;

/**
 * JSP访问权限控制过滤器
 * @author emanon
 *
 */
public class LoginValidateFilter implements Filter {

	private FilterConfig config;
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		this.config = null;
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = (HttpServletRequest) arg0;
		HttpServletResponse response = (HttpServletResponse) arg1;
		HttpServletResponseWrapper responseWrapper = new HttpServletResponseWrapper(response);
		FilterChain chain = arg2;
		
		//登陆页面
		String loginPage = config.getInitParameter("loginPage");
		String managePage = config.getInitParameter("managePage");
		//是否禁用过滤器
		String disableFilter = config.getInitParameter("disableFilter");
		
		//如果禁用过滤器，直接返回
		if (disableFilter.equals("Y")) {
			chain.doFilter(request, response);
			return;
		}
		
		String isLogin = (String) request.getSession().getAttribute("isLogin");
		
		//如果是登陆页面，不进行过滤，直接返回
		//如果已经登陆，则登陆请求全部跳转至管理界面
		System.out.println(request.getRequestURI());
		if (isContain(request.getRequestURI(), loginPage) ) {
			if (isLogin != null && isLogin == "yes") {
				responseWrapper.sendRedirect(managePage);
				return;
			}
			chain.doFilter(request, response);
			return;
		}
		
		//如果不是登陆页面并且未登陆，则先跳转至登陆页面
		if (isLogin == null || isLogin.equals("no")) {
			responseWrapper.sendRedirect(loginPage);
			return;
		} else {
			chain.doFilter(request, response);
			return;
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		this.config = arg0;
	}

	private static boolean isContain(String container, String regx) {
        if (container.indexOf(regx) != -1) {
            return true;
        } else {
        	return false;
        }
    }
}
