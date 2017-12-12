package com.autotest.action;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import com.autotest.biz.UserBiz;
import com.autotest.biz.UserBizImpl;
import com.autotest.dao.TestDAO;
import com.autotest.dao.TestDAOImpl;
import com.autotest.dao.VersionDAO;
import com.autotest.dao.VersionDAOImpl;
import com.autotest.entity.Test;
import com.autotest.entity.Version;
import com.autotest.util.FileUtil;
import com.autotest.util.UUIDUtil;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

/**
 * 发起测试Action
 * @author emanon
 *
 */
public class TestLaunchAction extends ActionSupport {
	
	private File uploadFile;
	private String uploadFileFileName;
	private String uploadFileContentType;
	private String type;
	private String serialNumber;
	private String testSource;
	
	public File getUploadFile() {
		return uploadFile;
	}
	
	public void setUploadFile(File uploadFile) {
		this.uploadFile = uploadFile;
	}
	
	public String getUploadFileFileName() {
		return uploadFileFileName;
	}
	
	public void setUploadFileFileName(String uploadFileFileName) {
		this.uploadFileFileName = uploadFileFileName;
	}
	
	public String getUploadFileContentType() {
		return uploadFileContentType;
	}
	
	public void setUploadFileContentType(String uploadFileContentType) {
		this.uploadFileContentType = uploadFileContentType;
	}
	
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	}
	
	public String getSerialNumber() {
		return serialNumber;
	}
	
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	
	public String getTestSource() {
		return testSource;
	}

	public void setTestSource(String testSource) {
		this.testSource = testSource;
	}

	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		Map<String, Object> loginInfo = ActionContext.getContext().getSession();
		String loginName = (String) loginInfo.get("loginName");
		String loginPassword = (String) loginInfo.get("loginPassword");
		//提交时间作为版本ID
		SimpleDateFormat current = new SimpleDateFormat("yyyyMMddHHmmss");
		String id = current.format(new Date());
		Version version = new Version(id, type, serialNumber, loginName);
		VersionDAO versionDAO = new VersionDAOImpl();
		versionDAO.add(version);
		boolean flag = FileUtil.FileUpload(uploadFile, uploadFileFileName);
		//UUID作为测试ID
		String uuid = UUIDUtil.getUUID();
		UserBiz userBiz = new UserBizImpl();
		Test test = new Test();
		if (userBiz.userLogin(loginName, loginPassword)) {
			test.setId(uuid);
			test.setVersionId(version.getId());
			test.setType(type);
			test.setSerialNumber(serialNumber);
			test.setState(0);
			test.setTestSource(testSource);
			test.setLoginName(loginName);
		}
		TestDAO testDAO = new TestDAOImpl();
		testDAO.add(test);
		flag = FileUtil.GenerateTestResult(uuid);
		return "success";
	}
}
