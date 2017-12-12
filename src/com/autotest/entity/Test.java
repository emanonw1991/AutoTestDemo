package com.autotest.entity;

import java.io.Serializable;

import com.autotest.util.UUIDUtil;

/**
 * 测试实体类
 * @author emanon
 *
 */
public class Test implements Serializable {
	private String id;
	private String versionId;
	private String type;
	private String serialNumber;
	//测试状态：0：已提交；1：测试中；2：测试成功；3：出现错误
	private int state;
	private String testSource;
	private String loginName;
	
	public Test() {}
	
	public Test(String id, String versionId, String type, String serialNumber, int state, String testSource, String loginName) {
		super();
		this.id = id;
		this.versionId = versionId;
		this.type = type;
		this.serialNumber = serialNumber;
		this.state = state;
		this.testSource = testSource;
		this.loginName = loginName;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getVersionId() {
		return versionId;
	}

	public void setVersionId(String versionId) {
		this.versionId = versionId;
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

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getTestSource() {
		return testSource;
	}

	public void setTestSource(String testSource) {
		this.testSource = testSource;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
}
