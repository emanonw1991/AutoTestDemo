package com.autotest.entity;

import java.io.Serializable;

/**
 * 版本实体类
 * @author emanon
 *
 */
public class Version implements Serializable {
	private String id;
	private String type;
	private String serialNumber;
	private String loginName;
	
	public Version() {}

	public Version(String id, String type, String serialNumber, String loginName) {
		super();
		this.id = id;
		this.type = type;
		this.serialNumber = serialNumber;
		this.loginName = loginName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
}
