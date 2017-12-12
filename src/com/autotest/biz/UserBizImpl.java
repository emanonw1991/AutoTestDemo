package com.autotest.biz;

import com.autotest.dao.UserDAO;
import com.autotest.dao.UserDAOImpl;
import com.autotest.entity.User;
import com.autotest.util.HQLUtil;

/**
 * 用户Biz层接口实现
 * @author emanon
 *
 */
public class UserBizImpl implements UserBiz {

	@Override
	public boolean userLogin(String loginName, String loginPassword) {
		// TODO Auto-generated method stub
		UserDAO userDAO = new UserDAOImpl();
		return userDAO.validate(loginName, loginPassword);
	}

	@Override
	public int getId(String loginName, String loginPassword) {
		// TODO Auto-generated method stub
		String hql = "select id from User as u where loginName = '"+loginName+"' and loginPassword = '"+loginPassword+"'";
		int id = (int) HQLUtil.search(hql).get(0);
		return id;
	}

}
