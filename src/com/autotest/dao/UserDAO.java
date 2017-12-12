package com.autotest.dao;

import com.autotest.entity.User;

/**
 * User DAO��ӿ�
 * @author emanon
 *
 */
public interface UserDAO {
	public void add(User user);
	public void delete(User user);
	public User get(int id);
	public void update(User users);
	public boolean validate(String loginName, String loginPassword);
}
