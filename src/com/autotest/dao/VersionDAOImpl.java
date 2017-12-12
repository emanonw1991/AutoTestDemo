package com.autotest.dao;

import com.autotest.entity.Version;

/**
 * Version DAO≤„ µœ÷
 * @author Administrator
 *
 */
public class VersionDAOImpl extends BaseHibernateDAO implements VersionDAO {

	@Override
	public void add(Version version) {
		// TODO Auto-generated method stub
		super.add(version);
	}

	@Override
	public void delete(Version version) {
		// TODO Auto-generated method stub
		super.detele(version);
	}

	@Override
	public Version get(String id) {
		// TODO Auto-generated method stub
		return (Version) super.get(Version.class, id);
	}

	@Override
	public void update(Version version) {
		// TODO Auto-generated method stub
		super.update(version);
	}

}
