package com.autotest.dao;

import java.util.ArrayList;
import java.util.List;

import com.autotest.entity.Test;

/**
 * Test DAO≤„ µœ÷
 * @author emanon
 *
 */
public class TestDAOImpl extends BaseHibernateDAO implements TestDAO {

	@Override
	public void add(Test test) {
		// TODO Auto-generated method stub
		super.add(test);
	}

	@Override
	public void delete(Test test) {
		// TODO Auto-generated method stub
		super.detele(test);
	}

	@Override
	public Test get(String id) {
		// TODO Auto-generated method stub
		return (Test) super.get(Test.class, id);
	}

	@Override
	public void update(Test test) {
		// TODO Auto-generated method stub
		super.update(test);
	}
}
