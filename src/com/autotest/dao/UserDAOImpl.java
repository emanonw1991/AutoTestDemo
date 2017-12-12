package com.autotest.dao;

import java.util.List;

import com.autotest.entity.User;

/**
 * User DAO层实现
 * @author Administrator
 *
 */
public class UserDAOImpl extends BaseHibernateDAO implements UserDAO {

	@Override
	public void add(User user) {
		// TODO Auto-generated method stub
		super.add(user);
	}

	@Override
	public void delete(User user) {
		// TODO Auto-generated method stub
		super.detele(user);
	}

	@Override
	public User get(int id) {
		// TODO Auto-generated method stub
		return (User) super.get(User.class, id);
	}

	@Override
	public void update(User user) {
		// TODO Auto-generated method stub
		super.update(user);
	}

	//验证登陆信息
	@Override
	public boolean validate(String loginName, String loginPassword) {
		// TODO Auto-generated method stub
		boolean flag = false;
		User condition = new User();
		condition.setLoginName(loginName);
		condition.setLoginPassword(loginPassword);
		List list = super.search(User.class, condition);
		if (list.size() > 0) {
			flag = true;
		}
		return flag;
	}

}
