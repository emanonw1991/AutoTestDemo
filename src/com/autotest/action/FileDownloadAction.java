package com.autotest.action;

import java.io.InputStream;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * �ļ�����Action
 * @author emanon
 *
 */
public class FileDownloadAction extends ActionSupport {
	
	private String downloadFileFileName;
	
	public String getDownloadFileFileName() {
		return downloadFileFileName;
	}

	public void setDownloadFileFileName(String downloadFileFileName) {
		this.downloadFileFileName = downloadFileFileName;
	}

	public InputStream getDownloadFile() {
		//�����ļ�����JSP����
		System.out.println(downloadFileFileName);
		return ServletActionContext.getServletContext().getResourceAsStream("/TestResults/"+downloadFileFileName);
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		return super.execute();
	}
}
