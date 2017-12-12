package com.autotest.dao;

import com.autotest.entity.Test;

/**
 * Test DAO²ã½Ó¿Ú
 * @author emanon
 *
 */
public interface TestDAO {
	public void add(Test test);
	public void delete(Test test);
	public Test get(String id);
	public void update(Test test);
}
