package com.autotest.entity;

import java.io.Serializable;

import com.autotest.util.UUIDUtil;

/**
 * ����ʵ����
 * @author emanon
 *
 */
public class Test implements Serializable {
	private String id;
	private String versionId;
	private String type;
	private String serialNumber;
	//����״̬��0�����ύ��1�������У�2�����Գɹ���3�����ִ���
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
