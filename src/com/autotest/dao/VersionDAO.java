package com.autotest.dao;

import com.autotest.entity.Version;

/**
 * Version DAO��ӿ�
 * @author emanon
 *
 */
public interface VersionDAO {
	public void add(Version version);
	public void delete(Version version);
	public Version get(String id);
	public void update(Version version);
}
