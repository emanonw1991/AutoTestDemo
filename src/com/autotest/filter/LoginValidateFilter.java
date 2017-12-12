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
 * JSP����Ȩ�޿��ƹ�����
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
		
		//��½ҳ��
		String loginPage = config.getInitParameter("loginPage");
		String managePage = config.getInitParameter("managePage");
		//�Ƿ���ù�����
		String disableFilter = config.getInitParameter("disableFilter");
		
		//������ù�������ֱ�ӷ���
		if (disableFilter.equals("Y")) {
			chain.doFilter(request, response);
			return;
		}
		
		String isLogin = (String) request.getSession().getAttribute("isLogin");
		
		//����ǵ�½ҳ�棬�����й��ˣ�ֱ�ӷ���
		//����Ѿ���½�����½����ȫ����ת���������
		System.out.println(request.getRequestURI());
		if (isContain(request.getRequestURI(), loginPage) ) {
			if (isLogin != null && isLogin == "yes") {
				responseWrapper.sendRedirect(managePage);
				return;
			}
			chain.doFilter(request, response);
			return;
		}
		
		//������ǵ�½ҳ�沢��δ��½��������ת����½ҳ��
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
