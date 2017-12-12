package com.autotest.dao;

import com.autotest.entity.Test;

/**
 * Test DAO��ӿ�
 * @author emanon
 *
 */
public interface TestDAO {
	public void add(Test test);
	public void delete(Test test);
	public Test get(String id);
	public void update(Test test);
}
