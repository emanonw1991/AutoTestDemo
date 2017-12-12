package com.autotest.dao;

import com.autotest.entity.Version;

/**
 * Version DAO²ã½Ó¿Ú
 * @author emanon
 *
 */
public interface VersionDAO {
	public void add(Version version);
	public void delete(Version version);
	public Version get(String id);
	public void update(Version version);
}
